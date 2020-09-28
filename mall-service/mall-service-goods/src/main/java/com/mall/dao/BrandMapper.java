package com.mall.dao;

/*通用mapper
* 增加数据mapper.insert
* 增加数据 mapper.insertSelective()
*
* 修改数据 mapper.update()
* 修改数据 mapper.updateByPrimayKey(T)
*
* 查询数据
*   mapper.selectByPrimayKey
*
* */


import com.mall.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper; //通用mapper

import java.util.List;
import java.util.Map;

public interface BrandMapper extends Mapper<Brand> {

    /*
     * 根据分类名称查询品牌列表
     *
     * @Param categoryName
     *
     *@ return
     * */
    @Select("SELECT name,image FROM tb_brand WHERE id IN (SELECT " +
            "brand_id FROM tb_category_brand WHERE category_id IN (SELECT id FROM " +
            "tb_category WHERE NAME=#{name}) )order by seq")
    public List<Map> findListByCategoryName(String categoryName);
}
