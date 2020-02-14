package com.yt.test.uploadfile;

import com.yt.test.Test1;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UploadFileTest
 * @Description 文件上传测试类
 * @createTime 2020年02月14日 12:13:00
 */
public class UploadFileTest extends Test1 {

    @Value("${cbs.imagesPath}")
    private String string;

    @Test
    public void pathTest(){
        System.out.println(string);
    }
}
