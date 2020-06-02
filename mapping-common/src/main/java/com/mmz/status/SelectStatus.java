package com.mmz.status;

/**
 * @program: springcloud-mapping
 * @description: 查询返回信息的枚举
 * @author: Liu Xinpeng
 * @create: 2020-05-28 14:51
 **/
public enum SelectStatus {

    SELECT_SUCCESS("20003", "查询成功"),
    SELECT_FAILED("10006", "查询失败");

    SelectStatus(String code, String msg) {
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
