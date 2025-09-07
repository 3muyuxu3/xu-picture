package com.xu.xupicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.xu.xupicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class XuPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(XuPictureBackendApplication.class, args);
    }
}
