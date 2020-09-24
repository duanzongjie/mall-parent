package com.mall.controller;


import com.mall.goods.pojo.Brand;
import com.mall.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    /*
    *
    * 查询所有品牌*/
    @GetMapping
    public Result<List<Brand>> findAll(){
     List<Brand> brands= brandService.findAll();
        return new Result<>(true, StatusCode.OK,"查询品牌集合" ,brands);
    }

    /*
    * 根据id查询品牌
    * */
    @GetMapping(value = "/{id}")
    public Result<Brand> find(@PathVariable(value = "id") int id){
        Brand brand=brandService.findByPrimaryKey(id);
        return new Result<>(true, StatusCode.OK,"根据Id查询品牌" ,brand);
    }

    /*
    * 增加品牌
    * RequestBody 将前台post的Json转换为Object
    *PostMapping 接收Post请求
    *
    * */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        /*
        * 调用service实现增加操作
        * */
        brandService.add(brand);
        return new Result<>(true, StatusCode.OK,"增加品牌" ,null);
    }

    /*
    * 更新品牌
    *
    * putMapping
    * */

    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id") int id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result<>(true, StatusCode.OK,"修改成功" ,null);
    }

    /*
    * 删除品牌
    *
    * @Param id
    * */

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") int id){
        brandService.delete(id);
        return new Result<>(true, StatusCode.OK,"删除成功" ,null);
    }

    /*条件查询
    **/
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
         List<Brand> brands= brandService.findList(brand);
        return new Result<>(true, StatusCode.OK,"条件搜索成功" ,brands);
    }

}
