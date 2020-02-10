package com.yt.service.springsecurity;

import com.yt.entity.JwtUser;
import com.yt.entity.User;
import com.yt.mapper.repository.UserRepository;
import com.yt.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserDetailsServiceImpl
 * @Description 使用springSecurity需要实现UserDetailsService接口供权限框架调用
 * @createTime 2020年02月04日 11:17:00
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{

        User user = new User();
        user = userRepository.findByUsername(s);
        // 如果redis中没有该用户, 则将改用户加入redis中
        if (!(redisUtils.hHasKey("onlineSystemUser",s))){
            Map<String, Object> map = new HashMap<>();
            map.put(s,user);
            redisUtils.hmset("onlineSystemUser",map);
        }
        return new JwtUser(user);
    }

    // 从redis中统计在线系统用户
    public Map<Object,Object> countOnlineSystemUser(){
        Map<Object,Object> map = redisUtils.hmget("onlineSystemUser");
        return map;
    }

    // 从redis中移除系统用户
    public Map<String,Integer> deleteOnlineSystemUser(String username){
        Map<String, Integer> map = new HashMap<>();
        redisUtils.hdel("onlineSystemUser",username);
        map.put("msg",1);
        return map;
    }

}
