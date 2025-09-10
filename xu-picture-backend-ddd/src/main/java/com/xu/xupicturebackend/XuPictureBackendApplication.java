package com.xu.xupicturebackend;

import org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@MapperScan("com.xu.xupicturebackend.mapper")
@SpringBootApplication(exclude = {ShardingSphereAutoConfiguration.class})
@EnableAspectJAutoProxy(exposeProxy = true)
public class XuPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(XuPictureBackendApplication.class, args);
    }
}
