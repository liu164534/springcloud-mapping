package com.mmz.base;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * @program: spring-cloud-mapping
 * @description:
 *      将数据库中相同的字段写到BaseModel中，其他的实体类直接继承这个类就可以了
 * @author: Liu Xinpeng
 * @create: 2020-05-20 16:28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseModel implements Serializable {

    /**
     * 主键、非空
     */
    @Id
    @NotNull
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @Max(value = 100, message = "时间最长不能超过100")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @Max(value = 100, message = "时间最长不能超过100")
    private String modifyTime;
}