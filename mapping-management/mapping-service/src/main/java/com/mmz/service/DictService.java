package com.mmz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmz.base.BaseService;
import com.mmz.mapper.DictMapper;
import com.mmz.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Jia Hao Hao
 * @Date: 2020-05-28 22:44
 * @Description: 字典管理
 **/
@Service
public class DictService extends BaseService<Dict> {
    @Autowired
    private DictMapper dictMapper;

//    /**
//     * @author Jia Hao Hao
//     * @param [pageNo, pageSize]
//     * @date 2020/5/28
//     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
//     * @description 查询所有字典表信息
//     * @throws
//     **/
//    public PageInfo<Dict> selectDictInfo(Integer pageNo, Integer pageSize){
//        PageHelper.startPage(pageNo,pageSize);
//        List<Dict> dicts = dictMapper.selectAll();
//        if (dicts.size() > 0){
//            PageInfo<Dict> dictPageInfo = new PageInfo<>(dicts);
//            return dictPageInfo;
//        }
//        return null;
//    }

    /**
     * @author Jia Hao Hao
     * @param [pageNum, pageSize]
     * @date 2020/5/28
     * @return com.github.pagehelper.PageInfo<com.mmz.model.Dict>
     * @description 查询所有字典表信息
     * @throws
    **/
    public List<Dict> selectAllDictInfo(){
        //查询字典表所有信息
        List<Dict> dictList = dictMapper.selectAll();
        //判断是否查询到数据
        if(null != dictList && 0 < dictList.size()){
            return dictList;
        }else{
            //如果没有数据返回空
            return null;
        }
    }

    /**
     * @author Jia Hao Hao
     * @param [dict]
     * @date 2020/5/28
     * @return int
     * @throws
     * @description 新增字典信息
    **/
    public Boolean insertDictInfo(Dict dict){
        if (!"".equals(dict) && null != dict){
            //新增字典信息
            int insert = dictMapper.insert(dict);
            //判断是否新增成功
            if (insert > 0){
                return true;
            }
        }
        return false;
    }

    /**
     * @author Jia Hao Hao
     * @param [ids]
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 批量删除字典信息
    **/
    public Integer deleteDictInfo(List<Object> ids){
        //判断是否为空
        if (ids.size() == 0){
            //如果为空直接返回空
            return null;
        }else {
            try {
                //执行批量删除
                Integer delete = super.delete(ids);
                if (delete > 0){
                    //返回收影响行数
                    return delete;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 根据id删除字典信息
     **/
    public Integer deleteDictId(Dict dict) {
        if ("".equals(dict) && null == dict) {
            return null;
        } else {
            //根据id删除字典信息
            int i = dictMapper.deleteByPrimaryKey(dict);
            if (i > 0) {
                //删除成功，返回受影响行数
                return i;
            } else {
                return null;
            }
        }

    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 根据id查询字典信息
     **/
    public Dict selectDictId(Dict dict) {
        if ("".equals(dict) && null == dict) {
            return null;
        } else {
            //根据id查询字典信息
            Dict dict1 = dictMapper.selectByPrimaryKey(dict);
            if (!"".equals(dict1) && null != dict1) {
                //查询成功，返回数据
                return dict1;
            } else {
                return null;
            }
        }

    }

    /**
     * @author Jia Hao Hao
     * @param
     * @date 2020/5/28
     * @return java.lang.Boolean
     * @throws
     * @description 修改字典信息
     **/
    public Integer updateDictInfo(Dict dict){
        //判断dict是否为空
        if (!"".equals(dict) && dict != null){
            //根据id修改字典信息
            int i = dictMapper.updateByPrimaryKey(dict);
            if (i > 0){
                //修改成功返回受影响行数
                return i;
            }
        }
        return null;
    }

}
