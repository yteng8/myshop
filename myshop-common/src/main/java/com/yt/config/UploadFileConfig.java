package com.yt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UploadFileConfig
 * @Description 文件上传配置类
 * @createTime 2020年02月14日 13:00:00
 */
@Configuration
@PropertySource("classpath:mycommon.properties")
@Component
public class UploadFileConfig {
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(uploadFolder);
        //文件最大
        factory.setMaxFileSize(DataSize.parse("50MB"));
        // 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("1024MB"));
        return factory.createMultipartConfig();
    }
}
