package com.mmz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "t_dict")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
/**
 * 字典实体
 */
public class Dict implements Serializable {
    /**
     * 字典ID
     */
    @Id
    @Column(name = "DICT_ID")
    private String dictId;

    /**
     * 键
     */
    @Column(name = "KEYY")
    private String keyy;

    /**
     * 值
     */
    @Column(name = "VALUEE")
    private String valuee;

    /**
     * 字段名称
     */
    @Column(name = "FIELD_NAME")
    private String fieldName;

    /**
     * 表名
     */
    @Column(name = "TABLE_NAME")
    private String tableName;

}