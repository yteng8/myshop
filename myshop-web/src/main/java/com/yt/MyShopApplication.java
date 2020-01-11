package com.yt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.yt")
@MapperScan(basePackages = "com.yt.myshop.mapper")

public class MyShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopApplication.class);
    }
}
