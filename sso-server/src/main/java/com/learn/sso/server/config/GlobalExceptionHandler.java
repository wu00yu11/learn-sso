package com.learn.sso.server.config;

/**
 * Date:                    2019/4/1 13:52
 * @Author:                kevin.wang
 * Company:                 kuaiqian
 * Version:                 1.0.0
 * Description:             类
 */

import com.alibaba.fastjson.JSON;
import com.learn.sso.core.bean.Result;
import com.learn.sso.core.constants.ResponseCode;
import com.learn.sso.core.exception.RspException;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 用来处理bean validation异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result constraintViolationExceptionHandler(ConstraintViolationException ex){
        Result response = new Result();
        String rspMsg = ResponseCode.ERROR_PARAMETER.getMessage();
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        if(!CollectionUtils.isEmpty(constraintViolations)){
            StringBuilder msgBuilder = new StringBuilder();
            for(ConstraintViolation constraintViolation :constraintViolations){
                msgBuilder.append(constraintViolation.getMessage()).append("|");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            rspMsg += "(" + errorMessage + ")";
        }
        response.setRspCode(ResponseCode.ERROR_PARAMETER.getCode());
        response.setRspMsg(rspMsg);
        logger.info(String.format("返回：%s\r\n", JSON.toJSON(response)));
        return response;
    }

    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    public Result methodArgumentNotValidException(Exception ex){
        Result response = new Result();
        String rspMsg = ResponseCode.ERROR_PARAMETER.getMessage();
        BindingResult bindResult = null;
        if (ex instanceof BindException) {
             bindResult = ((BindException) ex).getBindingResult();
        }else if (ex instanceof MethodArgumentNotValidException) {
             bindResult = ((MethodArgumentNotValidException) ex).getBindingResult();
        }

        List<ObjectError> objectErrors = bindResult.getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append("|");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            rspMsg += "(" + errorMessage + ")";
        }else {
            rspMsg = "系统繁忙，请稍后重试...";
        }

        response.setRspCode(ResponseCode.ERROR_PARAMETER.getCode());
        response.setRspMsg(rspMsg);
        logger.info(String.format("返回：%s\r\n", JSON.toJSON(response)));
        return response;
    }

    @ExceptionHandler(MyBatisSystemException.class)
    @ResponseBody
    public Result rspExceptionHandler(MyBatisSystemException myBatisSystemException) {
        logger.error("MyBatisSystemException:", myBatisSystemException);
        Result response = new Result(ResponseCode.ERROR_OTHER);
        logger.info(String.format("返回：%s\r\n", JSON.toJSON(response)));
        return response;
    }


    @ExceptionHandler(RspException.class)
    @ResponseBody
    public Result rspExceptionHandler(RspException rspException) {
        logger.error("RspException:", rspException);
        Result response = new Result(rspException.getCode(),rspException.getMsg());
        logger.info(String.format("返回：%s\r\n", JSON.toJSON(response)));
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result rspExceptionHandler(Exception exception) {
        logger.error("Exception:", exception);
        Result response = new Result(ResponseCode.ERROR_OTHER);
        logger.info(String.format("返回：%s\r\n", JSON.toJSON(response)));
        return response;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result rspExceptionHandler(Throwable throwable) {
        Result response = new Result(ResponseCode.ERROR_OTHER);
        logger.info(String.format("返回：%s\r\n", JSON.toJSON(response)));
        return response;
    }

}
