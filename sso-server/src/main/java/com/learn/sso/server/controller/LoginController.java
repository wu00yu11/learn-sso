package com.learn.sso.server.controller;

import com.learn.sso.core.bean.Result;
import com.learn.sso.core.constants.ResponseCode;
import com.learn.sso.server.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wu00y
 */
@Controller
@RequestMapping(value = "/login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    public Result login(){
        return new Result("0000","Success");
    }

}
