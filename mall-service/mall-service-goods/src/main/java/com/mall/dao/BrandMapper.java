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
import tk.mybatis.mapper.common.Mapper; //通用mapper

public interface BrandMapper extends Mapper<Brand> {
}
