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
@RequestMapping("/brand")
public interface BrandFeign {

    /***
     * Brand分页条件搜索实现
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable  int page, @PathVariable  int size);

    /***
     * Brand分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param brand
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Brand>> findList(@RequestBody(required = false) Brand brand);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Brand数据
     * @param brand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Brand brand,@PathVariable Integer id);

    /***
     * 新增Brand数据
     * @param brand
     * @return
     */
    @PostMapping
    Result add(@RequestBody Brand brand);

    /***
     * 根据ID查询Brand数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Brand> findById(@PathVariable Integer id);

    /***
     * 查询Brand全部数据
     * @return
     */
    @GetMapping
    Result<List<Brand>> findAll();
}