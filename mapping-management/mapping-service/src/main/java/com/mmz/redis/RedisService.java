package com.mmz.redis;

import com.mmz.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

import static com.mmz.staticstatus.RedisProperties.*;
/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-05-23 22:30
 **/
public class RedisService<T> {

    /**
     * 连接redis集群的客户端
     */
    @Autowired
    private JedisCluster jedisCluster;

    /**
    * @Description: 向redis中保存数据并设置失效时间
     *          key:redis中的key
     *          value: 向redis中存储的数据
     *          nxxx:
     *              这里的值是固定的
     *              "nx":如果redis中的key不存在则可以存储数据
     *              "xx":如果redis中的key存在才可以存储数据
     *
     *          expx:
     *              时间的单位(这里也是固定的)
     *              "ex":失效时间的单位为秒
     *              "px"：失效时间的单位为毫秒
     *          seconds：
     *              失效时间(如果缺省则说明不需要设置失效时间)
    * @Param: [key, value, nxxx, expx, seconds]
    * @return: java.lang.String
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    public String set(String key, T value, String nxxx, String expx, Integer seconds) {
        if (null != seconds && 0< seconds && (NX.equals(nxxx) || XX.equals(nxxx) && EX.equals(expx) || PX.equals(expx))) {
            // 说明需要设置超时时间  TODO
            return jedisCluster.set(key, JSONUtils.toJsonString(value),nxxx,expx,seconds);
        } else {
            // 说明不需要设置超时时间
            // 就算不需要设置超时时间，也需要判断传递的是nx还是xx
            if (NX.equals(nxxx)) {
                return String.valueOf(jedisCluster.setnx(key, JSONUtils.toJsonString(value)));
            } else if(XX.equals(nxxx)){
                return jedisCluster.set(key, JSONUtils.toJsonString(value));
            }
        }
        return NO;
    }
}