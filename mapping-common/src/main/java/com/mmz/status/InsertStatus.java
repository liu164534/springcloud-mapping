package com.mmz.status;

/**
 * @program: spring-cloud-mapping
 * @description: 新增结果的枚举类型
 * @author: Liu Xinpeng
 * @create: 2020-05-24 15:34
 **/
public enum InsertStatus {

    INSERT_SUCCESS("20003","新增成功"),
    INSERT_FAILED("10006","新增失败");

    InsertStatus(String code, String msg) {
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