package com.mmz.service;

import com.mmz.base.BaseService;
import com.mmz.mapper.UserMapper;
import com.mmz.model.User;
import com.mmz.redis.RedisService;
import com.mmz.utils.IDUtils;
import com.mmz.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mmz.staticstatus.RedisProperties.*;
/**
 * @program: spring-cloud-mapping
 * @description:
 * @author: Liu Xinpeng
 * @create: 2020-05-24 18:00
 */
@Service
public class LoginService extends BaseService<User> {

  @Autowired private UserMapper userMapper;

  /**
   * @Description: 执行登陆操作 @Param: [user, redisService]
   *
   * @return: com.mmz.vo.TokenVo @Author: Liu Xinpeng @Date: 2020/5/24
   */
  public TokenVo doLogin(User user, RedisService redisService) {
    TokenVo tokenVo = new TokenVo();
    tokenVo.setIfSuccess(false);
    // 1.判断(当前执行的是登陆操作，而也就是说用户在执行登陆操作的时候肯定没有token值)
    if (null != user) {
      // 2.验证账号密码是否正确
      User u = userMapper.selectOne(user);
      // 3.判断查询到的数据，如果不为null则说明账号密码正确
      if (null != u) {
        // 4.用户登陆成功，生成UUID作为token的值
        String token = IDUtils.getUUID();
        u.setToken(token);
        int updateResult = userMapper.updateByPrimaryKey(u);
        // 5.判断token值是否更新成功
        if (updateResult > 0) {
          // 由于用户登陆的时候存的token值设置了失效时间，失效时间过了之后就无法操作这个key了，所以将用户ID作为key存进去
          String setResultF = redisService.set(String.valueOf(u.getId()), token, NX,EX,null);
          // 判断当这个key不存在的时候才会存入成功
          if ("OK".equals(setResultF)) {
            /**
             * 说明token更新成功，需要返回token的值，因为以后每个方法都会去查询这个token的值， 频繁的查询数据库会影响系统的效率，所以存在缓存里边(redis)
             * 并设置响应的失效时间 在这里设置的是只有在redsi中存在这个key才可以修改，失效时间的格式为秒
             */
            String setResultS = redisService.set(String.valueOf(u.getId()), token, XX, EX, 1800);
            // 返回值是OK
            if ("OK".equals(setResultS.toUpperCase())) {
              return tokenVo
                      .setIfSuccess(true)
                      .setToken(token)
                      .setRedisKey(String.valueOf(u.getId()));
            }
          }
          // 说明这个key已经存在
          String setResultS = redisService.set(String.valueOf(u.getId()), token, XX, EX, 1800);
          // 返回值是OK
          if ("OK".equals(setResultS.toUpperCase())) {
            return tokenVo
                    .setIfSuccess(true)
                    .setToken(token)
                    .setRedisKey(String.valueOf(u.getId()));
          }
        }
      }
    }
    return tokenVo;
  }
}
