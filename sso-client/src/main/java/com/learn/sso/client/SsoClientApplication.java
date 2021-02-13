package com.learn.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wu00y
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.learn.sso"})
public class SsoClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoClientApplication.class);
    }
}
