package com.learn.sso.core.bean;

import com.learn.sso.core.constants.ResponseCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wu00y
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {
    /**请求响应码*/
    private String code;
    /**请求响应码映射信息*/
    private String message;
    /**业务请求响应码*/
    private String bizCode;
    /**业务请求响应码映射信息*/
    private String bizMessage;
    /**数据集*/
    private T data;

    /**
     * @param bizCode
     * @param bizMessage
     */
    public Result(String bizCode, String bizMessage) {
        this(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),bizCode,bizMessage,null);
    }

    /**
     * @param bizCode
     * @param bizMessage
     * @param data
     */
    public Result(String bizCode, String bizMessage, T data) {
        this(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),bizCode,bizMessage,data);
    }

    /**
     * @param code
     * @param message
     * @param bizCode
     * @param bizMessage
     * @param data
     */
    public Result(String code, String message, String bizCode, String bizMessage, T data) {
        this.code = code;
        this.message = message;
        this.bizCode = bizCode;
        this.bizMessage = bizMessage;
        this.data = data;
    }
}
