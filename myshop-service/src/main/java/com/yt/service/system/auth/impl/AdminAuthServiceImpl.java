package com.yt.service.system.auth.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yt.entity.page.PageRequest;
import com.yt.entity.page.PageResult;
import com.yt.mapper.repository.UserRepository;
import com.yt.model.system.user.Role;
import com.yt.model.system.user.SystemUserInfo;
import com.yt.model.system.user.UserRole;
import com.yt.model.system.user.vo.SystemUserInfoVo;
import com.yt.service.system.auth.AdminAuthService;
import com.yt.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public PageResult getAllSystemUserInfo(Integer pageNum, Integer pageSize) {
        PageRequest pageQuery = new PageRequest();
        pageQuery.setPageNum(pageNum);
        pageQuery.setPageSize(pageSize);
        return PageUtils.getPageResult(pageQuery, getPageInfo(pageQuery));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<SystemUserInfoVo> getPageInfo(PageRequest pageRequest) {
        Integer pageNum = pageRequest.getPageNum();
        Integer pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SystemUserInfoVo> systemUserInfoVos = userRepository.selectAllSystemUserInfoByPage();
        return new PageInfo<SystemUserInfoVo>(systemUserInfoVos);
    }

    @Override
    @Transactional
    public Map<String, Integer> modifySystemUserInfo(Map<String, String> modifyUser) {
        SystemUserInfo systemUserInfo = new SystemUserInfo();
        systemUserInfo.setId(Integer.parseInt(modifyUser.get("id")));
        systemUserInfo.setUsername(modifyUser.get("username"));
        // 密码只能本人更改, 入职时间和用户id不能更改
        systemUserInfo.setAge(Integer.parseInt(modifyUser.get("age")));
        systemUserInfo.setReal(modifyUser.get("real"));
        systemUserInfo.setSex(Integer.parseInt(modifyUser.get("sex")));
        systemUserInfo.setRoleName(modifyUser.get("roleName"));
        Role role = new Role();
        role.setRolename(systemUserInfo.getRoleName());
        UserRole userRole = new UserRole();
        userRole.setUserId(systemUserInfo.getId());
        userRole.setRoleName(systemUserInfo.getRoleName());
        Map<String, Integer> msg = new HashMap<String, Integer>();
        int existRoleName = userRepository.selectExistRoleName(role);
        int returnFlag = -1;
        // 如果角色名存在，则只更新用户表和角色关联表
        if (existRoleName > 0) {
            int updateNum1 = userRepository.updateSystemInfoToSystemUser(systemUserInfo);
            // 根据roleName 查询roleId
            int backRoleId = userRepository.selectRoleIdByRoleName(userRole);
            userRole.setRoleId(backRoleId);
            int updateNum2 = userRepository.updateSystemInfoToSystemUserRole(userRole);
            if (updateNum1 == 1 && updateNum2 == 1) {
                returnFlag = 1;
            }
            // 如果角色名不存在，则需要更新用户表,角色表和用户角色关联表
        } else if (existRoleName == 0) {
            // 向system_user 插入数据
            int updateNum3 = userRepository.updateSystemInfoToSystemUser(systemUserInfo);
            // 向角色表中插入新增的角色
            userRepository.insertRolename(role); //返回角色id
            // 向system_user_role 插入数据
            System.out.println("--------  "+role.getId());
            userRole.setRoleId(role.getId());
            System.out.println("-------roleId "+userRole.getRoleId());
            System.out.println("-------userId "+userRole.getUserId());
            int updateNum4 = userRepository.updateSystemInfoToSystemUserRole(userRole);
            if (updateNum3 == 1 || updateNum4 == 1) {
                returnFlag = 1;
            }

        }
        msg.put("msg",returnFlag);
        return msg;
    }


}
