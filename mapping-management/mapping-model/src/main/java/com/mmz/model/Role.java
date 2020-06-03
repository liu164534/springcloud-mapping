package com.mmz.model;

import com.mmz.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * @program: springcloud-mapping
 * @description: 角色表
 * @author: Mr.Miao
 * @create: 2020-06-03 23:27
 **/
@Table(name = "t_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role   implements Serializable {
    /**
     * 角色主键id
     */
    @Column(name = "ROLE_ID")
    private Long roleId;
    /**
     * 角色名称
     **/
    private String roleName;
    /**
     * 角色描述
     **/

    private String remark;

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
