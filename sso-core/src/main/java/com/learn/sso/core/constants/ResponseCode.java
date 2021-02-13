package com.learn.sso.core.constants;

/**
 * @author wu00y
 */
public enum ResponseCode {
    /**请求成功*/
    SUCCESS("0000","成功"),
    /**请求失败*/
    FAIL("9999","失败"),
    ;
    private final String code;
    private final String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
