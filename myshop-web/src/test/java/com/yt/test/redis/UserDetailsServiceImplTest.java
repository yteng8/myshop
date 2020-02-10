package com.yt.test.redis;

import com.yt.test.Test1;
import com.yt.util.RedisUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserDetailsServiceImplTest
 * @Description TODO
 * @createTime 2020年02月10日 11:52:00
 */
public class UserDetailsServiceImplTest extends Test1 {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void deleteOnlineSystemUser() {
        redisUtils.hdel("onlineSystemUser","ggggg");
    }
}