package com.yt.filter;

import com.yt.entity.JwtUser;
import com.yt.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyLoginDuplicateFilter
 * @Description TODO
 * @createTime 2020年02月09日 11:27:00
 */
@Component
public class MyLoginDuplicateFilter {

    @Autowired
    RedisUtils redisUtils;

    public boolean checkLoginDuplicateFilter(JwtUser jwtUser){

        String username = jwtUser.getUsername();
        return redisUtils.hasKey(username);
    }

}
