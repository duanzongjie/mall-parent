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
@RequestMapping("/category")
public interface CategoryFeign {

    /***
     * Category分页条件搜索实现
     * @param category
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Category category, @PathVariable  int page, @PathVariable  int size);

    /***
     * Category分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param category
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Category>> findList(@RequestBody(required = false) Category category);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Category数据
     * @param category
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Category category,@PathVariable Integer id);

    /***
     * 新增Category数据
     * @param category
     * @return
     */
    @PostMapping
    Result add(@RequestBody Category category);

    /***
     * 根据ID查询Category数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Category> findById(@PathVariable Integer id);

    /***
     * 查询Category全部数据
     * @return
     */
    @GetMapping
    Result<List<Category>> findAll();
}