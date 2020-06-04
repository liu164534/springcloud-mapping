package com.mmz.model;

import javax.persistence.*;

@Table(name = "t_principal")
public class Principal {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 负责人类别
     */
    private String type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件类型
     */
    @Column(name = "id_type")
    private String idType;

    /**
     * 证件号码
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 年龄
     */
    private String age;

    /**
     * 性别 0:女 1:男 2:保密
     */
    private String sex;

    /**
     * 工作年限
     */
    @Column(name = "work_year")
    private String workYear;

    /**
     * 职务
     */
    private String duty;

    /**
     * 职称
     */
    private String title;

    /**
     * 从事测绘工作年限
     */
    @Column(name = "mapping_year")
    private String mappingYear;

    /**
     * 学历专业
     */
    private String major;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取负责人类别
     *
     * @return type - 负责人类别
     */
    public String getType() {
        return type;
    }

    /**
     * 设置负责人类别
     *
     * @param type 负责人类别
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取证件类型
     *
     * @return id_type - 证件类型
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置证件类型
     *
     * @param idType 证件类型
     */
    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    /**
     * 获取证件号码
     *
     * @return id_number - 证件号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置证件号码
     *
     * @param idNumber 证件号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    /**
     * 获取性别 0:女 1:男 2:保密
     *
     * @return sex - 性别 0:女 1:男 2:保密
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别 0:女 1:男 2:保密
     *
     * @param sex 性别 0:女 1:男 2:保密
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取工作年限
     *
     * @return work_year - 工作年限
     */
    public String getWorkYear() {
        return workYear;
    }

    /**
     * 设置工作年限
     *
     * @param workYear 工作年限
     */
    public void setWorkYear(String workYear) {
        this.workYear = workYear == null ? null : workYear.trim();
    }

    /**
     * 获取职务
     *
     * @return duty - 职务
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 设置职务
     *
     * @param duty 职务
     */
    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    /**
     * 获取职称
     *
     * @return title - 职称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置职称
     *
     * @param title 职称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取从事测绘工作年限
     *
     * @return mapping_year - 从事测绘工作年限
     */
    public String getMappingYear() {
        return mappingYear;
    }

    /**
     * 设置从事测绘工作年限
     *
     * @param mappingYear 从事测绘工作年限
     */
    public void setMappingYear(String mappingYear) {
        this.mappingYear = mappingYear == null ? null : mappingYear.trim();
    }

    /**
     * 获取学历专业
     *
     * @return major - 学历专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置学历专业
     *
     * @param major 学历专业
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * 获取单位用户编号
     *
     * @return user_id - 单位用户编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置单位用户编号
     *
     * @param userId 单位用户编号
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }
}