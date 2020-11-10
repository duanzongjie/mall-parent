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
@RequestMapping("/spec")
public interface SpecFeign {

    /***
     * Spec分页条件搜索实现
     * @param spec
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Spec spec, @PathVariable  int page, @PathVariable  int size);

    /***
     * Spec分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param spec
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Spec>> findList(@RequestBody(required = false) Spec spec);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Spec数据
     * @param spec
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Spec spec,@PathVariable Integer id);

    /***
     * 新增Spec数据
     * @param spec
     * @return
     */
    @PostMapping
    Result add(@RequestBody Spec spec);

    /***
     * 根据ID查询Spec数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Spec> findById(@PathVariable Integer id);

    /***
     * 查询Spec全部数据
     * @return
     */
    @GetMapping
    Result<List<Spec>> findAll();
}