package com.learn.sso.core.exception;

import com.learn.sso.core.constants.ResponseCode;

/**
 * Package:                 com.bill99.fto.cmdc.pay.exeption
 * Date:                    2019/4/1 15:49
 * @Author:                kevin.wang
 * Company:                 kuaiqian
 * Version:                 1.0.0
 * Description:             类
 */
public class RspException extends Exception {

    private String code;

    private String msg;

    public RspException(String code, String msg) {
        super("[" + code + "]" + msg);
        this.code = code;
        this.msg = msg;
    }

    public RspException(String code, String msg, Throwable cause) {
        super("[" + code + "]" + msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public RspException(ResponseCode rspEnum, String... args) {
        super("[" + rspEnum.getCode() + "]" +  String.format(rspEnum.getMessage(), args));
        this.code = rspEnum.getCode();
        this.msg = String.format(rspEnum.getMessage(), args);
    }

    public RspException(ResponseCode rspEnum) {
        super("[" + rspEnum.getCode() + "]" + rspEnum.getMessage());
        this.code = rspEnum.getCode();
        this.msg = rspEnum.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
