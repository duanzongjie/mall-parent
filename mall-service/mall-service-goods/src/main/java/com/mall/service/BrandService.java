package com.mall.service;

import com.mall.goods.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    /*
    * 查询所有的品牌
    * */

    List<Brand> findAll();


    /*
    * 根据主键查询品牌
    * */
    Brand findByPrimaryKey(int id);

    /*
    * 增加品牌
    * @Param
    * */
    void add(Brand brand);

    /*
    * 更新品牌
    *
    *
    * */
    void update(Brand brand);

    /*
    * 删除品牌
    * @Param id
    * */
    void delete(int id);

    /*
    * 多条件搜索
    * @Param brand
    * */
    public List<Brand> findList(Brand brand);

    /*
    * 根据分类名称查询品牌
    * */
    public List<Map> findListByCategoryName(String categoryName);

}
