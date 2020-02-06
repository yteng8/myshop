package com.yt.service.system.auth.impl;

import com.yt.exception.myexception.NoInputException;
import com.yt.mapper.repository.UserRepository;
import com.yt.model.system.user.Role;
import com.yt.model.system.user.SystemUserInfo;
import com.yt.service.system.auth.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminAuthServiceImpl
 * @Description 超级系统管理员管理子管理员和客服人员服务具体实现
 * @createTime 2020年02月05日 17:25:00
 */
@Service
public class AdminAuthServiceImpl implements AdminAuthService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public Map<String, Integer> registerUserService(Map<String, String> registerUser) {

        SystemUserInfo systemUserInfo = new SystemUserInfo();
        systemUserInfo.setUsername(registerUser.get("username"));
        systemUserInfo.setAge(Integer.parseInt(registerUser.get("age")));

        // 将接收的字符串转化为mysql中的Date日期
        String entryTimeString = registerUser.get("entryTime");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = sdf.parse(entryTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        systemUserInfo.setEntryTime(date);

        // 加密密码
        systemUserInfo.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        systemUserInfo.setReal(registerUser.get("real"));
        systemUserInfo.setSex(Integer.parseInt(registerUser.get("sex")));
        systemUserInfo.setRoleName(registerUser.get("roleName"));
        Role role = new Role();
        role.setRolename(systemUserInfo.getRoleName());
        Map<String, Integer> msg = new HashMap<String, Integer>();
        int returnFlag = -1;
        // flag=0 表示用户不存在 flag>0 表示用户存在
        int flag = userRepository.selectExistUserByUsername(systemUserInfo);
        if (flag > 0) {
            returnFlag = 0;
        } else if (flag == 0) {
            // 如果角色id>0 则表示角色存在
            int selectRoleId = userRepository.selectExistRoleName(role);
            if (selectRoleId > 0) {
                // 如果角色存在则先插入用户信息，再向system_user_role插入
                userRepository.insertSystemUserInfo(systemUserInfo);
                int systemUserInfoId = systemUserInfo.getId();
                userRepository.insertUserIdAndRoleId(systemUserInfoId, selectRoleId);
                returnFlag = 1;
            } else {
                // 角色不存在
                userRepository.insertSystemUserInfo(systemUserInfo);
                int systemUserInfoId = systemUserInfo.getId();
                userRepository.insertRolename(role);
                int roleId = role.getId();
                userRepository.insertUserIdAndRoleId(systemUserInfoId, roleId);
                returnFlag = 1;
            }
        }
        msg.put("msg", returnFlag);
        return msg;

    }
}
