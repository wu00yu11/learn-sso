package com.learn.sso.server.service.impl;

import com.learn.sso.server.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wu00y
 */

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public void login() {
        log.info("login sucess!");
    }
}

