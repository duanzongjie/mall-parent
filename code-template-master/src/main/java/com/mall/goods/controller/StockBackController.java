package com.mall.goods.controller;
import com.mall.goods.pojo.StockBack;
import com.mall.goods.service.StockBackService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "StockBackController")
@RestController
@RequestMapping("/stockBack")
@CrossOrigin
public class StockBackController {

    @Autowired
    private StockBackService stockBackService;

    /***
     * StockBack分页条件搜索实现
     * @param stockBack
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "StockBack条件分页查询",notes = "分页条件查询StockBack方法详情",tags = {"StockBackController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "StockBack对象",value = "传入JSON数据",required = false) StockBack stockBack, @PathVariable  int page, @PathVariable  int size){
        //调用StockBackService实现分页条件查询StockBack
        PageInfo<StockBack> pageInfo = stockBackService.findPage(stockBack, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * StockBack分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "StockBack分页查询",notes = "分页查询StockBack方法详情",tags = {"StockBackController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用StockBackService实现分页查询StockBack
        PageInfo<StockBack> pageInfo = stockBackService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param stockBack
     * @return
     */
    @ApiOperation(value = "StockBack条件查询",notes = "条件查询StockBack方法详情",tags = {"StockBackController"})
    @PostMapping(value = "/search" )
    public Result<List<StockBack>> findList(@RequestBody(required = false) @ApiParam(name = "StockBack对象",value = "传入JSON数据",required = false) StockBack stockBack){
        //调用StockBackService实现条件查询StockBack
        List<StockBack> list = stockBackService.findList(stockBack);
        return new Result<List<StockBack>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "StockBack根据ID删除",notes = "根据ID删除StockBack方法详情",tags = {"StockBackController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用StockBackService实现根据主键删除
        stockBackService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改StockBack数据
     * @param stockBack
     * @param id
     * @return
     */
    @ApiOperation(value = "StockBack根据ID修改",notes = "根据ID修改StockBack方法详情",tags = {"StockBackController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "StockBack对象",value = "传入JSON数据",required = false) StockBack stockBack,@PathVariable String id){
        //设置主键值
        stockBack.setSkuId(id);
        //调用StockBackService实现修改StockBack
        stockBackService.update(stockBack);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增StockBack数据
     * @param stockBack
     * @return
     */
    @ApiOperation(value = "StockBack添加",notes = "添加StockBack方法详情",tags = {"StockBackController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "StockBack对象",value = "传入JSON数据",required = true) StockBack stockBack){
        //调用StockBackService实现添加StockBack
        stockBackService.add(stockBack);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询StockBack数据
     * @param id
     * @return
     */
    @ApiOperation(value = "StockBack根据ID查询",notes = "根据ID查询StockBack方法详情",tags = {"StockBackController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<StockBack> findById(@PathVariable String id){
        //调用StockBackService实现根据主键查询StockBack
        StockBack stockBack = stockBackService.findById(id);
        return new Result<StockBack>(true,StatusCode.OK,"查询成功",stockBack);
    }

    /***
     * 查询StockBack全部数据
     * @return
     */
    @ApiOperation(value = "查询所有StockBack",notes = "查询所StockBack有方法详情",tags = {"StockBackController"})
    @GetMapping
    public Result<List<StockBack>> findAll(){
        //调用StockBackService实现查询所有StockBack
        List<StockBack> list = stockBackService.findAll();
        return new Result<List<StockBack>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
