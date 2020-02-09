package com.yt.test;

import com.yt.MyShopApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test1
 * @Description TODO
 * @createTime 2020年02月09日 13:53:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyShopApplication.class)
public class Test1 {
    @Test
    public void tes(){
        System.out.println(111);
    }
}
