package com.mmz.base;

import com.mmz.status.LoginStatus;
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
     *      解决硬编码的方式：
     *          使用静态常量
     *          使用枚举
     *          使用properties
    * @Param: []
    * @return: com.exam.shiro.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/4/6
    */
    protected ResultData success(){
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
    */
    protected ResultData success(String msg){
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
    protected ResultData success(Object data){
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
    protected ResultData success(String msg,Object data){
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
    protected ResultData failed(){
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
    protected ResultData failed(String msg){
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
    protected ResultData failed(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    
    /**
    * @Description:  注册时发送验证码，用户已经存在
    * @Param: []
    * @return: com.exam.shiro.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/4/8
    */
    protected ResultData userExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.USER_EXIST.getCode());
        resultData.setMsg(LoginStatus.USER_EXIST.getMsg());
        return resultData;
    }

    /**
    * @Description: 通用的成功 使用系统消息
    * @Param: []
    * @return: com.exam.shiro.base.ResultData
    * @Author: Liu Xinpeng
    * @Date: 2020/4/8
    */
    protected ResultData generalSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.SUCCESS.getCode());
        resultData.setMsg(LoginStatus.SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 通用的成功 使用自定义消息
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/8
     */
    protected ResultData generalSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 通用的成功 有返回值
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/8
     */
    protected ResultData generalSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.SUCCESS.getCode());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 通用的成功 使用自定义消息 有返回值
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/8
     */
    protected ResultData generalSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }





    /**
     * @Description: 通用的失败 使用系统消息
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/8
     */
    protected ResultData generalFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.FALIED.getCode());
        resultData.setMsg(LoginStatus.FALIED.getMsg());
        return resultData;
    }

    /**
     * @Description: 通用的失败 使用自定义消息
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/8
     */
    protected ResultData generalFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.FALIED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 通用的失败 有返回值
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/8
     */
    protected ResultData generalFailed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.FALIED.getCode());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @Description: 通用的失败 使用自定义消息 有返回值
     * @Param: []
     * @return: com.exam.shiro.base.ResultData
     * @Author: Liu Xinpeng
     * @Date: 2020/4/8
     */
    protected ResultData generalFailed(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.FALIED.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

}