package com.learn.sso.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wu00y
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.learn.sso"})
@MapperScan("com.learn.sso.server.dao")
@ServletComponentScan
public class SsoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoServerApplication.class);
    }
}
