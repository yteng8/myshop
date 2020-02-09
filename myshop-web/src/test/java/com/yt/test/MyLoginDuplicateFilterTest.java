package com.yt.test;

import com.yt.entity.User;
import com.yt.util.RedisUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyLoginDuplicateFilterTest
 * @Description TODO
 * @createTime 2020年02月09日 14:09:00
 */

public class MyLoginDuplicateFilterTest extends Test1{

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void checkLoginDuplicateFilter(){

        try {
            System.out.println(redisUtils.hasKey("systemLoginUser"));
            System.out.println(redisUtils.hHasKey("sysnUr", "yt"));
            User user = (User)redisUtils.hget("systemLoginUser","yt");
            System.out.println(user.getRole());
        } catch (Exception e){
            throw new RuntimeException("Redis连接异常");
        }

    }
}
