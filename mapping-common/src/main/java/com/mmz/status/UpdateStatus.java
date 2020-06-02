package com.mmz.status;

/**
 * @program: springcloud-mapping
 * @description: 修改返回类型的枚举
 * @author: Liu Xinpeng
 * @create: 2020-06-01 20:10
 **/
public enum  UpdateStatus {
    UPDATE_SUCCESS("20006","修改成功"),
    UPDATE_FAILED("10009","修改失败");

    UpdateStatus(String code, String msg) {
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
