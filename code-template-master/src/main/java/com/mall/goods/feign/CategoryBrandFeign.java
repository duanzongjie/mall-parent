package com.changgou.content.feign;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/categoryBrand")
public interface CategoryBrandFeign {

    /***
     * CategoryBrand分页条件搜索实现
     * @param categoryBrand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) CategoryBrand categoryBrand, @PathVariable  int page, @PathVariable  int size);

    /***
     * CategoryBrand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param categoryBrand
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<CategoryBrand>> findList(@RequestBody(required = false) CategoryBrand categoryBrand);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改CategoryBrand数据
     * @param categoryBrand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody CategoryBrand categoryBrand,@PathVariable Integer id);

    /***
     * 新增CategoryBrand数据
     * @param categoryBrand
     * @return
     */
    @PostMapping
    Result add(@RequestBody CategoryBrand categoryBrand);

    /***
     * 根据ID查询CategoryBrand数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<CategoryBrand> findById(@PathVariable Integer id);

    /***
     * 查询CategoryBrand全部数据
     * @return
     */
    @GetMapping
    Result<List<CategoryBrand>> findAll();
}