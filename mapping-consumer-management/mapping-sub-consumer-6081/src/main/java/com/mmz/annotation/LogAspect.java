package com.mmz.annotation;

import com.mmz.model.User;
import com.mmz.service.IUserService;
import com.mmz.utils.DateUtils;
import com.mmz.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-cloud-mapping
 * @description: 日志的aop
 * @author: Liu Xinpeng
 * @create: 2020-05-28 10:24
 **/
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private IUserService IUserService;

    /**
    * @Description:
     *      定义一个切面
     *      之前应用的切面一边情况下切类，还可以使用通配符，或者可以切整个包
     *      eg: com.mmz.*.controller
     *
     *      这里要切自定义的注解
     *      也就是说当检测到这个注解存在的时候，aop才会生效
    * @Param: []
    * @return: void
    * @Author: Liu Xinpeng
    * @Date: 2020/5/28
    */
    @Pointcut("@annotation(com.mmz.annotation.LoginLogAnnotation)")
    public void pointcut() {
        // TODO 什么都不写，定义了具体切哪一部分，切的注解
    }
    /**
    * @Description: 定义环形切点
     *        ProceedingJoinPoint：
     *          里面封装了目标路径中的所有参数，可以任意获取
    * @Param: [proceedingJoinPoint]
    * @return: java.lang.Object
    * @Author: Liu Xinpeng
    * @Date: 2020/5/28
    */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws ClassNotFoundException, UnknownHostException{
        // 1.定义返回值
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // 2.获取username信息，其实username的信息就在方法的参数中，也就是说只要获取目标方法的参数就可以获取username的值
        Object[] args = proceedingJoinPoint.getArgs();
        User user = null;
        for (Object arg : args) {
            user = (User) arg;
        }
        // 3.获取登陆时间
        String date = DateUtils.getDateTime();
        //4 .通过Request对象获取获取IP地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = IPUtils.getIpAddr(request);
        //5.获取operationType和operationName
        // 获取方法所属类的全限定名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        // 获取目标方法的方法名
        String targetMethodName = proceedingJoinPoint.getSignature().getName();
        // 通过反射获取类的对象
        Class targetClass = Class.forName(className);
        // 获取目标类中的所有方法
        Method[] methods = targetClass.getMethods();
        String operationType = "";
        String operationName = "";

        // 通过循环来进行对比判断
        for (Method method : methods) {
            String methodName = method.getName();
            // 判断两个methodName是否相等
            if (methodName.equals(targetMethodName)) {
                // 需要考虑到方法的重载，对应方法中参数的个数
                Class[] parameterTypes = method.getParameterTypes();
                // 判断两个方法中的参数个数是否相同
                if (parameterTypes.length == args.length) {
                    // 获取最终的目标方法注解中的属性
                    operationType = method.getAnnotation(LoginLogAnnotation.class).operationType();
                    operationName = method.getAnnotation(LoginLogAnnotation.class).operationName();
                }
            }
        }

        Map map = new HashMap();
        map.put("username", user.getUsername());
        map.put("loginTime",date);
        map.put("ip", ip);
        map.put("location", "河南");
        map.put("operationType", operationType);
        map.put("operationName", operationName);
        IUserService.addLoginLog(map);
        // 如果不return则永远不会返回目标controller
        return result;
    }
}