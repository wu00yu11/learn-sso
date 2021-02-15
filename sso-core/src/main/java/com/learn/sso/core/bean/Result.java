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
    /** 通信返回码 */
    private String rspCode;
    /** 通信返回信息 */
    private String rspMsg;
    /** 分页信息*/
    private Page page;
    /**数据集*/
    private T data;

    public Result(ResponseCode responseCode){
        this(responseCode.getCode(), responseCode.getMessage(),null,null);
    }

    public Result(ResponseCode responseCode,T data){
        this(responseCode.getCode(), responseCode.getMessage(),null,data);
    }

    public Result(ResponseCode responseCode,Page page,T data){
        this(responseCode.getCode(), responseCode.getMessage(),page,data);
    }

    public Result(String rspCode, String rspMsg) {
       this(rspCode,rspMsg,null,null);
    }

    public Result(String rspCode, String rspMsg, T data) {
        this(rspCode,rspMsg,null,data);
    }

    public Result(String rspCode, String rspMsg, Page page, T data) {
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
        this.page = page;
        this.data = data;
    }
}
