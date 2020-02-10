package com.yt.test;

import com.yt.entity.User;
import com.yt.util.RedisUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

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

        Map<Object,Object> map = redisUtils.hmget("systemLoginUser");
        for (Map.Entry<Object,Object> entry: map.entrySet()
             ) {
            System.out.println(entry.getKey()+"    "+entry.getValue());
        }

    }


}
