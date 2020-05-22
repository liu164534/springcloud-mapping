package com.mmz.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: 20200402-exam-shiro-springboot
 * @description:
 *      在http返回的值是有固定格式的
 *          code
 *          message
 *          data:就是需要返回给前端的数据
 *          Exception
 * @author: Liu Xinpeng
 * @create: 2020-04-06 16:38
 **/
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {
    private String code;
    private String msg;
    private String detail;
    private T data;
}