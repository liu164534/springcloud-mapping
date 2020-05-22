package com.mmz.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: spring-cloud-mapping
 * @description: 获取spring容器的工具类
 * @author: Liu Xinpeng
 * @create: 2020-05-21 14:17
 **/
public class SpringContextUtils implements ApplicationContextAware {

    private SpringContextUtils() {

    }

    private static ApplicationContext APPLICATIONCONTEXT = null;
    private static final ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATIONCONTEXT = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        Lock lock = READ_WRITE_LOCK.readLock();
        lock.lock();
        try {
            if(null != APPLICATIONCONTEXT) {
                return APPLICATIONCONTEXT;
            } else {
                return null;
            }
        } finally {
            lock.unlock();
        }
    }
}