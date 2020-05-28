package com.mmz.base;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-05-24 14:34
 **/
public abstract class CommonController<T> extends BaseController {

    /**
    * @Description: 钩子函数，在新增之前执行的内容
    * @Param: [map]
    * @return: void
    * @Author: Liu Xinpeng
    * @Date: 2020/5/24
    */
    protected void beforeAdd(Map map) {
        // TODO 钩子函数，插入之前需要执行的操作
    }
    
    /**
    * @Description: 钩子函数新增之后执行的内容
    * @Param: [map]
    * @return: void 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/24
    */
    protected void afterAdd(Map map) {
        // TODO 钩子函数，新增之后执行的内容
    }

    // TODO 这个方法不明白什么意思
    public abstract BaseService<T> getBaseService();


    /**
    * @Description: 新增数据
    * @Param: [map]
    * @return: com.mmz.base.ResultData 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/28
    */
    public ResultData add(@RequestBody Map map) {
        ResultData resultData = new ResultData();
        // 执行新增之前的钩子函数
        beforeAdd(map);
        // 将传入的map类型转换成对应的实体类型
        T instance = getBaseService().newInstance(map);
        try{
            Integer insertResult = getBaseService().add(instance);
            System.out.println("日志");
            if (insertResult > 0) {
                // 说明新增成功
                afterAdd(map);
                return insertSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertFailed();
    }


    // TODO delete, batchDelete, update, getOne, getList, getListByPage(不带条件的分页查询)
    /**
    * @Description: 防止数据不安全，所以不能直接在controoller中的某个方法中直接接收HttpServletReques对象
     *              必须要从本地当前线程中获取对象
     *              TODO 没有理解
    * @Param: []
    * @return: javax.servlet.http.HttpServletRequest
    * @Author: Liu Xinpeng
    * @Date: 2020/5/24
    */
    public HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }

    /**
    * @Description: 获取当前客户端传递的session对象，如果不存在则会重新创建一个
    * @Param: []
    * @return: javax.servlet.http.HttpSession
    * @Author: Liu Xinpeng
    * @Date: 2020/5/24
    */
     public HttpSession getSession() {
        return getHttpServletRequest().getSession();
     }

     /**
     * @Description: 获取当前客户端的session，如果不存在直接返回null
     * @Param: []
     * @return: javax.servlet.http.HttpSession
     * @Author: Liu Xinpeng
     * @Date: 2020/5/24
     */
     public HttpSession getExistSession() {
         return getHttpServletRequest().getSession(false);
     }

}