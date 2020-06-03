package com.mmz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @program: springcloud-mapping
 * @description: 用户权限
 * @author: Mr.Miao
 * @create: 2020-06-02 17:36
 **/
@Table(name = "t_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable {

    /**
     * 用户id
     */
    @Column(name = "USER_ID")
        private String userId;

    /**
     * 权限id
     */
    @Column(name = "ROLE_ID")
    private String roleId;
    
}
