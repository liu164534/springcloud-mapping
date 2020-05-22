package com.mmz.status;

/**
 * @program: spring-cloud-mapping
 * @description: 登陆返回信息的枚举
 * @author: Liu Xinpeng
 * @create: 2020-05-21 13:45
 **/
public enum LoginStatus {

    SUCCESS("20000","成功"),
    FALIED("10000","失败"),
    LOGIN_SUCCESS("20001", "登录成功"),
    LOGIN_FAILED("10001", "登录失败"),
    USER_EXIST("20002", "用户存在"),
    USER_NOT_EXIST("10002", "用户不存在"),
    PASSWORD_WRONG("10003", "密码错误"),
    USER_LOCKED("10004", "账号被锁定"),
    LOGOUT_WRONG("10005", "用户退出异常");


    LoginStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
