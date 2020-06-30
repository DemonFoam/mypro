package com.sexflag.mypro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * vue项目的后台
 * 使用 mybatis-generator 逆向工程插件
 * 使用 shiro 安全框架  进行权限控制
 */
@MapperScan("com.sexflag.mypro.dao")
@SpringBootApplication
public class MyproApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyproApplication.class, args);
    }

}
