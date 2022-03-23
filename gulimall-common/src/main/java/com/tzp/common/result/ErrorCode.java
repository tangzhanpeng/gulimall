package com.tzp.common.result;

public enum ErrorCode {
    /************************************************
     * 登录注册相关错误码(业务级错误码)
     ************************************************/
    BLANK_MOBILE("-1000", "手机号码为空！"),
    BLANK_VERIFY_CODE("-1001", "图形验证码为空！"),
    INVALID_MOBILE("-1002", "无效手机号码！"),
    BLANK_PASSWORD("-1003", "密码不能为空！"),
    INVALID_PASSWORD("-1004", "密码长度至少6位数！"),
    EXPIRE_VERIFY_CODE("-1005", "图形验证码已过期！"),
    ERROR_VERIFY_CODE("-1006", "图形验证码错误！"),
    BLANK_MESSAGE_VERIFY_CODE("-1007", "短信验证码为空！"),
    EXPIRE_MESSAGE_VERIFY_CODE("-1008", "短信验证码已过期！"),
    ERROR_MESSAGE_VERIFY_CODE("-1009", "短信验证码错误！"),
    EXIST_REGISTER_MOBILE_PHONE("-1010", "已经注册过的手机号码！"),
    BLANK_USER("-1011", "用户名或手机号为空！"),
    UN_REGISTER_USER("-1012", "未注册过用户名或手机号！"),
    ERROR_PASSWORD("-1013", "登录密码错误！");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
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
