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
@RequestMapping("/sku")
public interface SkuFeign {

    /***
     * Sku分页条件搜索实现
     * @param sku
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Sku sku, @PathVariable  int page, @PathVariable  int size);

    /***
     * Sku分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sku
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Sku>> findList(@RequestBody(required = false) Sku sku);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改Sku数据
     * @param sku
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Sku sku,@PathVariable Long id);

    /***
     * 新增Sku数据
     * @param sku
     * @return
     */
    @PostMapping
    Result add(@RequestBody Sku sku);

    /***
     * 根据ID查询Sku数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Sku> findById(@PathVariable Long id);

    /***
     * 查询Sku全部数据
     * @return
     */
    @GetMapping
    Result<List<Sku>> findAll();
}