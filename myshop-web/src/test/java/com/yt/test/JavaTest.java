package com.yt.test;

import org.junit.Test;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JavaTest
 * @Description java普通测试
 * @createTime 2020年02月14日 14:25:00
 */
public class JavaTest {

    @Test
    public void test1(){
        String s = "2jfsfsfsfsf.shhh.PGG";
        System.out.println(s.substring(s.lastIndexOf('.')+1));
        System.out.println((s.substring(s.lastIndexOf('.')+1)).toLowerCase());
    }
}
