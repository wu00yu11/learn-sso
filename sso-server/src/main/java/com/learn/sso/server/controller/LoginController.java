package com.learn.sso.server.controller;

import com.learn.sso.core.bean.Result;
import com.learn.sso.server.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wu00y
 */
@RestController
@RequestMapping
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public Result login(){
        log.info("login process begin ...+" +
                "");
        loginService.login();
        log.info("login process end ...");
        return new Result("0000","Success");
    }

}
