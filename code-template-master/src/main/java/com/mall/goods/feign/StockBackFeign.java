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
@RequestMapping("/stockBack")
public interface StockBackFeign {

    /***
     * StockBack分页条件搜索实现
     * @param stockBack
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) StockBack stockBack, @PathVariable  int page, @PathVariable  int size);

    /***
     * StockBack分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param stockBack
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<StockBack>> findList(@RequestBody(required = false) StockBack stockBack);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改StockBack数据
     * @param stockBack
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody StockBack stockBack,@PathVariable String id);

    /***
     * 新增StockBack数据
     * @param stockBack
     * @return
     */
    @PostMapping
    Result add(@RequestBody StockBack stockBack);

    /***
     * 根据ID查询StockBack数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<StockBack> findById(@PathVariable String id);

    /***
     * 查询StockBack全部数据
     * @return
     */
    @GetMapping
    Result<List<StockBack>> findAll();
}