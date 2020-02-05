package com.yt.service.system.auth.impl;

import com.yt.mapper.repository.UserRepository;
import com.yt.model.user.SystemUserInfo;
import com.yt.service.system.auth.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public String registerUserService(Map<String, String> registerUser) {
        SystemUserInfo systemUserInfo = new SystemUserInfo();
        systemUserInfo.setUsername(registerUser.get("username"));
        systemUserInfo.setAge(Integer.parseInt(registerUser.get("age")));

        // 将接收的字符串转化为日期
        String entryTimeString = registerUser.get("entryTime");
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        try {
            systemUserInfo.setEntryTime(sdf.parse(entryTimeString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 加密密码
        systemUserInfo.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        systemUserInfo.setReal(registerUser.get("real"));
        systemUserInfo.setSex(Integer.parseInt(registerUser.get("sex")));
        systemUserInfo.setRoleName(registerUser.get("roleName"));


        return null;
    }
}
