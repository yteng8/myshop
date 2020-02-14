package com.yt.controller.system_auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestController
 * @Description TODO
 * @createTime 2020年02月14日 13:21:00
 */
@RestController
public class TestController {

    @PostMapping("/test")
    public String tbUpload(@RequestParam("filename") MultipartFile file, HttpServletRequest request)
            throws IllegalStateException, IOException {
        System.out.println(file);
       // System.out.println("length  " + files.length);
        // 判断文件上传
//        if (files.length > 0) {
//
//            for (MultipartFile multipartFile : files) {
                // 获取上传文件的原始名字

                String originalFilename = file.getOriginalFilename();
                // 一般决定于项目设计的时候时规范的路径
                String dirPath = "E:\\IDEA_workspace\\myshopImg\\";
                File filePath = new File(dirPath);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }

                // 使用uuid唯一标识文件
                String newFilename = UUID.randomUUID() + "_" + originalFilename;
                // 设置文件保存路径和名字
                file.transferTo(new File(filePath + "/" + newFilename));
//            }
//            return "aa";
//        } else {
//            return "bb";
//        }
        return "aa";
    }
}
