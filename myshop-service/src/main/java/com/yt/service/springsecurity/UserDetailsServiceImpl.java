package com.yt.service.springsecurity;

import com.yt.entity.JwtUser;
import com.yt.entity.User;
import com.yt.exception.myexception.LoginDuplicateException;
import com.yt.mapper.repository.UserRepository;
import com.yt.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        // 先向redis中查找是否存在, 如果存在则不再产生token

        if (redisUtils.hHasKey("systemLoginUser",s)){

            user = (User) redisUtils.hget("systemLoginUser",s);
            return new JwtUser(null);
        }else {
            // 如果redis中没有, 则先向数据库中拿取, 再将user存进Redis中 设置过期时间
            user = userRepository.findByUsername(s);
            redisUtils.hset("systemLoginUser", s, user);
            return new JwtUser(user);
        }

        //User user = new User();
        //user = userRepository.findByUsername(s);
        // return new JwtUser(user);
    }

}
