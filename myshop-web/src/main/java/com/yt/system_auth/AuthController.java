package com.yt.system_auth;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.yt.repository.UserRepository;
import com.yt.service.springsecurity.UserDetailsServiceImpl;
import com.yt.system.SystemAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName 系统管理员的登录
 * @Description TODO
 * @createTime 2020年02月04日 14:51:00
 */
@RestController
public class AuthController {

//    @Autowired
//    private UserRepository userRepository;

    // @Autowired
    // SystemAuthService systemAuthService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/login")
    public Map<String,String> login(){

        return null;
    }

}
