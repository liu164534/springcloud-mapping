package com.mmz.base;

import com.mmz.status.InsertStatus;
import com.mmz.status.LoginStatus;
import com.mmz.status.SelectStatus;
import com.mmz.status.UpdateStatus;
import org.springframework.stereotype.Controller;

/**
 * @program: 20200402-exam-shiro-springboot
 * @description: 对返回的消息类型做规范
 * @author: Liu Xinpeng
 * @create: 2020-04-06 16:35
 **/
@Controller
public class BaseController {


    /**
     * @Description: 登陆成功 使用系统消息 没有返回值
     * 解决硬编码的方式：
     * 使用静态常量
     * 使用枚举
     * 使用properties
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/6
     */
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 登陆成功 使用自定义消息 没有返回值
     * @Param: [msg]
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/6
     *
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 登陆成功 使用系统消息 有返回值
     * @Param: [msg]
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/6
     */
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 登陆成功 使用自定义消息 有返回值
     * @Param: [msg]
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/6
     */
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 登陆失败 使用系统消息 没有返回值
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/6
     */
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(LoginStatus.LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 登陆失败 自定义返回消息 没有返回值
     * @Param: [msg]
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/6
     */
    protected ResultData loginFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 登陆失败 自定义返回消息 有返回值
     * @Param: [msg]
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/6
     */
    protected ResultData loginFailed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(LoginStatus.LOGIN_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 登陆失败 使用系统消息 有返回值
     * @Param: [msg]
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/6
     */
    protected ResultData loginFailed(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 注册时，验证用户是否存在
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/8
     */
    protected ResultData userExist() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.USER_EXIST.getCode());
        resultData.setMsg(LoginStatus.USER_EXIST.getMsg());
        return resultData;
    }

    /**
     * @Description: 新增成功，不返回数据
     * @Param: []
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    protected ResultData insertSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(InsertStatus.INSERT_SUCCESS.getCode());
        resultData.setMsg(InsertStatus.INSERT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 新增成功，返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    protected ResultData insertSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(InsertStatus.INSERT_SUCCESS.getCode());
        resultData.setMsg(InsertStatus.INSERT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 新增失败，不返回数据
     * @Param: []
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    protected ResultData insertFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(InsertStatus.INSERT_FAILED.getCode());
        resultData.setMsg(InsertStatus.INSERT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 新增失败，返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    protected ResultData insertFailed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(InsertStatus.INSERT_FAILED.getCode());
        resultData.setMsg(InsertStatus.INSERT_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 查询成功，返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/28
     */
    protected ResultData selectSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SelectStatus.SELECT_SUCCESS.getCode());
        resultData.setMsg(SelectStatus.SELECT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 查询成功，不返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/28
     */
    protected ResultData selectSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SelectStatus.SELECT_SUCCESS.getCode());
        resultData.setMsg(SelectStatus.SELECT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 查询失败，返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/28
     */
    protected ResultData selectFailed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SelectStatus.SELECT_SUCCESS.getCode());
        resultData.setMsg(SelectStatus.SELECT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 查询失败，不返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/28
     */
    protected ResultData selectFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(SelectStatus.SELECT_FAILED.getCode());
        resultData.setMsg(SelectStatus.SELECT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 修改成功，不返回数据
     * @Param: []
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/6/1
     */
    protected ResultData updateSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(UpdateStatus.UPDATE_SUCCESS.getCode());
        resultData.setMsg(UpdateStatus.UPDATE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 修改成功，返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/6/1
     */
    protected ResultData updateSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(UpdateStatus.UPDATE_SUCCESS.getCode());
        resultData.setMsg(UpdateStatus.UPDATE_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 修改失败，不返回数据
     * @Param: []
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/6/1
     */
    protected ResultData updateFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(UpdateStatus.UPDATE_FAILED.getCode());
        resultData.setMsg(UpdateStatus.UPDATE_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 修改失败，返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/6/1
     */
    protected ResultData updateFailed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(UpdateStatus.UPDATE_FAILED.getCode());
        resultData.setMsg(UpdateStatus.UPDATE_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 删除成功，不返回数据
     * @Param: []
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    protected ResultData deleteSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(InsertStatus.INSERT_SUCCESS.getCode());
        resultData.setMsg(InsertStatus.INSERT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description:  删除成功，返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    protected ResultData deleteSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(InsertStatus.INSERT_SUCCESS.getCode());
        resultData.setMsg(InsertStatus.INSERT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 删除失败，不返回数据
     * @Param: []
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    protected ResultData deleteFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(InsertStatus.INSERT_FAILED.getCode());
        resultData.setMsg(InsertStatus.INSERT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 删除失败，返回数据
     * @Param: [data]
     * @return: com.mmz.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
    protected ResultData deleteFailed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(InsertStatus.INSERT_FAILED.getCode());
        resultData.setMsg(InsertStatus.INSERT_FAILED.getMsg());
        resultData.setData(data);
        return resultData;
    }
}