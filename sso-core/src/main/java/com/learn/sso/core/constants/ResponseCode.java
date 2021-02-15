package com.learn.sso.core.constants;

/**
 * @author wu00y
 */
public enum ResponseCode {
    ERROR_OTHER("9999", "系统内部异常"),
    SUCCESS("0000","成功"),
    ERROR_PARAMETER("2001", "参数校验错误"),
    ERROR_REPEATREQUEST("2002", "重复请求访问，请稍后再试"),
    TOKEN_FAILURE("2003", "登录验证信息失效,请重新登录"),
    USER_EXIST("2004", "用户已存在"),
    LOGINNAME_PASSWORD_ERROR("2005", "登录名或密码错误"),
    PERMISSION_DENIED("2006","权限不足,请联系管理员"),
    UPDATE_PASSWORD_ERROR("2007", "修改密码失败"),
    OLD_PASSWORD_NEW("2008", "新密码与旧密码相同,请重新输入"),
    DELETE_OPERATOR_ERROR("2009", "删除操作员失败"),
    UPDATE_OPERATOR_ERROR("2010", "更新操作员信息失败"),
    UPDATE_PERSONAL_INFO_ERROR("2011", "更新个人信息失败"),
    USER_DISENABLE_ERROR("2012", "用户已经停用"),
    OPERATOR_TYPE_ERROR("2013","操作员类型与分省不匹配"),
    USER_NOT_EXIST("2014", "用户不存在"),
    OLD_PASSWORD_ERROR("2015", "旧密码错误,请重新输入"),
    ROLE_ASS_USER("2016", "该角色存在关联用户,不能删除"),
    ROLE_EXIST("2017", "该角色已存在"),
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
