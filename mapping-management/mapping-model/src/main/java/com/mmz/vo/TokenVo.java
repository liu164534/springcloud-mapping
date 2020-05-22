package com.mmz.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-05-20 16:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TokenVo implements Serializable {

    /**
     * token的值
     */
    private String token;

    /**
     * 标识了该方法是否成功
     */
    private Boolean ifSuccess;

    /**
     * 保存token的值到redis缓存
     */
    private String redisKey;
}