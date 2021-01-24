package com.learn.sso.server.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wu00y
 */
@Data
@Slf4j
public class SsoServerException extends Exception{

    private String code;

    private String message;

    public SsoServerException() {
    }

    public SsoServerException(String code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
