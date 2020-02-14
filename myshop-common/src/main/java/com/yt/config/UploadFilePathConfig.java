package com.yt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UploadFilePathConfig
 * @Description TODO
 * @createTime 2020年02月14日 13:07:00
 */
@Configuration
@PropertySource("classpath:mycommon.properties")
public class UploadFilePathConfig extends WebMvcConfigurationSupport {
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:///" + uploadFolder);
    }
}
