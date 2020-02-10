package com.yt.startandend;

import com.yt.util.RedisUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyShopEnd
 * @Description 关闭项目执行类
 * @createTime 2020年02月10日 11:58:00
 */
@Component
public class MyShopEnd implements DisposableBean, ExitCodeGenerator {

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public void destroy() throws Exception {
        System.out.println("------ end ------");
        redisUtils.del("onlineSystemUser");
    }

    @Override
    public int getExitCode() {
        return -5;
    }
}
