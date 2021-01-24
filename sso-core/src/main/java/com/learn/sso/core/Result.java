package com.learn.sso.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.ResponseCache;

/**
 * @author wu00y
 */
@Data
@AllArgsConstructor
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

}
