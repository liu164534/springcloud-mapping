package com.mmz.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmz.utils.Map2BeanUtils;
import com.mmz.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @program: spring-cloud-mapping
 * @description:
 *      通用service 泛型T指的是实体类。传递什么实体类进来，就会往mapper中注入对应的实体类
 *      abstract修饰的是一个抽象类，不能被实例化
 *
 *      对Mybatis的通用mapper进行封装
 *
 *      example用来放一些去重，排序，分类，分页等信息 2.criteria用来传字段参数
 *      Mybatis 的mybatis-generator(逆行工程)会为每个字段产生Criterion
 *
 *      Criteria包含一个Cretiron的集合,每一个Criteria对象内包含的Cretiron之间是由AND连接的,是逻辑与的关系。
 *      Example内有一个成员叫oredCriteria,是Criteria的集合,就想其名字所预示的一样，这个集合中的Criteria是由OR连接的，是逻辑或关系。
 *      oredCriteria就是ORed Criteria。
 * @author: Liu Xinpeng
 * @create: 2020-05-20 16:44
 **/
public abstract class BaseService<T> {

    // 本地缓存池
    private Class<T> cache = null;

    // 通用mapper
    @Autowired
    private Mapper<T> mapper;

    /**
    * @Description:
     *      由于注入的mapper是private类型的，所以他它的子类就调用不到
     *      所以需要提供调用对象的方法
    * @Param: []
    * @return: tk.mybatis.mapper.common.Mapper
    * @Author: Liu Xinpeng
    * @Date: 2020/5/20
    */
    protected Mapper getMapper() { return mapper;}

    /**
    * @Description: 新增功能
    * @Param: [t]
    * @return: java.lang.Integer
    * @Author: Liu Xinpeng
    * @Date: 2020/5/20
    */
    public Integer add(T t) throws Exception {
        return mapper.insertSelective(t);
    }

    /**
    * @Description: 通过主键进行删除
    * @Param: [t]
    * @return: java.lang.Integer
    * @Author: Liu Xinpeng
    * @Date: 2020/5/20
    */
    public Integer delete(T t) throws Exception {
        return mapper.deleteByPrimaryKey(t);
    }

    /**
    * @Description: 通过主键进行批量删除
     *      能通过java进行处理的数据，就不使用子查询
     *      如果联查两张表以上，就要把联查拆开，放到java里边进行实现
    * @Param: [ids]
    * @return: java.lang.Integer
    * @Author: Liu Xinpeng
    * @Date: 2020/5/20
    */
    public Integer delete(List<Object> ids) throws Exception {
        Example example = Example.builder(getTypeArgument()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }


    /**
    * @Description: 修改功能
    * @Param: [t]
    * @return: java.lang.Integer 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/20
    */
    public Integer update(T t) throws Exception {
        return mapper.updateByPrimaryKeySelective(t);
    }


    /**
    * @Description: 批量修改
     *      t:所需要修改的数据（t代表实体类，只能存放一个id）
     *      ids:通过主键进行更新
   * @Param: [t, ids]
    * @return: java.lang.Integer
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    public Integer batchUpdate(T t, Object[] ids) throws Exception {
        Example example = Example.builder(getTypeArgument()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t, example);
    }

    /**
    * @Description: 查询一条数据
    * @Param: [t]
    * @return: T
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    public T queryOne(T t) throws Exception {
        return mapper.selectOne(t);
    }

    /**
    * @Description: 查询多条数据
    * @Param: [t]
    * @return: java.util.List<T>
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    public List<T> queryList(T t) throws Exception {
        return mapper.select(t);
    }

    /**
    * @Description: 分页查询
    * @Param: [t, pageNum, pageSize]
    * @return: com.github.pagehelper.PageInfo<T>
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    public PageInfo<T> queryListByPage(T t, Integer pageNum, Integer pageSize) throws  Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> PageInfo = new PageInfo<T>(select);
        return PageInfo;
    }
    /**
    * @Description: 通过指定字段查询一条数据
     *      有些表中有唯一主键
    * @Param: [where, orderByField, fields]
    * @return: T
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    public T queryByField(Sqls where, String orderByField, String... fields) throws Exception {
        return (T) queryByFieldsBase(null, null, where, orderByField, fields).get(0);
    }
    
    /**
    * @Description: 条件查询集合
    * @Param: [where, orderByField, fields]
    * @return: java.util.List<T> 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    public List<T> queryListByFields(Sqls where, String orderByField, String... fields) throws Exception {
        return queryByFieldsBase(null, null, where, orderByField, fields);
    }
    
    /**
    * @Description: 根据条件分页查询
    * @Param: [pageNum, pageSize, where, orderByFileds, fields]
    * @return: com.github.pagehelper.PageInfo<T> 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    public PageInfo<T> queryListByPageAndFields(Integer pageNum, Integer pageSize, Sqls where, String orderByFileds, String... fields) throws Exception {
        return new PageInfo<T>(queryByFieldsBase(pageNum, pageSize, where, orderByFileds, fields));
    }
    /**
    * @Description: 获取子类泛型的类型
    * @Param: []
    * @return: java.lang.Class<T>
    * @Author: Liu Xinpeng
    * @Date: 2020/5/20
    */
    private Class<T> getTypeArgument() {
        if(null == cache) {
            cache = (Class<T>) ((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        }
        return cache;
    }

    /**
    * @Description: 封装条件查询、分页查询以及排序查询的通用方法 （多条件查询）
    * @Param: [pageNum, pageSize, where, orderByField, field]
    * @return: java.util.List<T>
    * @Author: Liu Xinpeng
    * @Date: 2020/5/21
    */
    private List<T> queryByFieldsBase(Integer pageNum, Integer pageSize, Sqls where, String orderByField, String... field) {
        Example.Builder builder = null;
        if (null == field || field.length ==0) {
            // 没有条件查询，说明是查询所有数据
            builder = Example.builder(getTypeArgument());
        } else {
            // 指定某些/某个字段进行查询
            builder = Example.builder((getTypeArgument()))
                    .select(field);
        }
        if(null != where) {
            builder = builder.where(where);
        }

        if(null != orderByField) {
            builder = builder.orderByDesc(orderByField);
        }

        Example example = builder.build();

        if(null != pageNum && null != pageSize) { // pageHelper通用分页插件
            PageHelper.startPage(pageNum, pageSize);
        }

        List list = getMapper().selectByExample(example);
        return list;
    }
    
    /**
    * @Description: 通过反射获取实例对象
    * @Param: [map]
    * @return: T 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArgument());
    }

    
    /**
    * @Description: 获取spring上下文(容器)
    * @Param: []
    * @return: org.springframework.context.ApplicationContext 
    * @Author: Liu Xinpeng
    * @Date: 2020/5/23
    */
    public ApplicationContext getApplicationContext() {
        return SpringContextUtils.getApplicationContext();
    }

}