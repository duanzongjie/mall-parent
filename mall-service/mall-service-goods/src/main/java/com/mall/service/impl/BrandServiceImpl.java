package com.mall.service.impl;

import com.mall.dao.BrandMapper;
import com.mall.goods.pojo.Brand;
import com.mall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
       return  brandMapper.selectAll();
    }

    @Override
    public Brand findByPrimaryKey(int id) {
        /*
        * 通用Mapper
        *ByPrimayKey
        * */
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand){
        /*
        * Selective 忽略空值，某一列为空
        *
        * insert 不忽略
        * */
        brandMapper.insertSelective(brand);
    }

    /*
    * 通过主键更新
    * */

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(int id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /*
    * 多条件搜索，条件自定义
    * */
    @Override
    public List<Brand> findList(Brand brand) {
        Example example=  this.createExample(brand);
        return brandMapper.selectByExample(example);
    }

    @Override
    public List<Map> findListByCategoryName(String categoryName) {
        return brandMapper.findListByCategoryName(categoryName);
    }


    /*
    * 抽取拼装
    * */
    public Example createExample(Brand brand){
        /*
         * 自定义条件搜索对象 Example
         * */
        Example example=new Example(Brand.class);
        Example.Criteria criteria= example.createCriteria();//条件构造器

        if(null!=brand){
            //name is not null 根据名字模糊搜索
            if(!StringUtils.isEmpty(brand.getName())){
                //第一个参数为 字段名称，第二个参数为数据库占位符
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            //根据leteter搜索
            if(!StringUtils.isEmpty(brand.getLetter())){
                //第一个参数为 字段名称，第二个参数为数据库占位符
                criteria.andEqualTo("letter",brand.getName());
            }
        }
        return example;
    }
}
