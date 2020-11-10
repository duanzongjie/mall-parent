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
@RequestMapping("/spu")
public interface SpuFeign {

    /***
     * Spu分页条件搜索实现
     * @param spu
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Spu spu, @PathVariable  int page, @PathVariable  int size);

    /***
     * Spu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param spu
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Spu>> findList(@RequestBody(required = false) Spu spu);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Long id);

    /***
     * 修改Spu数据
     * @param spu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Spu spu,@PathVariable Long id);

    /***
     * 新增Spu数据
     * @param spu
     * @return
     */
    @PostMapping
    Result add(@RequestBody Spu spu);

    /***
     * 根据ID查询Spu数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Spu> findById(@PathVariable Long id);

    /***
     * 查询Spu全部数据
     * @return
     */
    @GetMapping
    Result<List<Spu>> findAll();
}