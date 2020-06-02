package com.mmz.status;

/**
 * @program: spring-cloud-mapping
 * @description: 删除操作返回的枚举类型
 * @author: Liu Xinpeng
 * @create: 2020-06-02 22:12
 **/
public enum DeleteStatus {

    DELETE_SUCCESS("20005","删除成功"),
    DELETE_FAILED("10008","删除失败");

    private String code;
    private String msg;

    DeleteStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}