package com.yt.controller.system_auth;

import com.yt.entity.User;
import com.yt.mapper.repository.UserRepository;
import com.yt.model.user.Role;
import com.yt.service.system.auth.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AdminAuthController
 * @Description 超级管理员管理子管理员和客服管理员
 * @createTime 2020年02月04日 14:51:00
 */
@RestController
@RequestMapping("/system/protected/auth/")
public class AdminAuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AdminAuthService adminAuthService;

    @PostMapping("register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
//        User user = new User();
//        user.setUsername(registerUser.get("username"));
//        // 记得注册的时候把密码加密一下
//        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
//        user.setRole("ROLE_CADMIN");
//        Role role = new Role();
//        role.setRolename(user.getRole());
//        userRepository.insertUsernameAndPassword(user);
//        System.out.println(user.getId());
//        userRepository.insertRolename(role);
//        int userId = user.getId();
//        int roleId = role.getId();
//        userRepository.insertUserIdAndRoleId(userId,roleId);
//        return user.toString();

        return adminAuthService.registerUserService(registerUser);
    }



}
