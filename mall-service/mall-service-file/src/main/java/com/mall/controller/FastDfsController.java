package com.mall.controller;


import com.mall.file.FastDfsFile;
import com.mall.util.FastDfsUtil;
import entity.Result;
import entity.StatusCode;
import net.sf.jsqlparser.schema.MultiPartName;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.spring.annotation.MapperScan;

@RestController
@RequestMapping(value = "/upload")
@CrossOrigin
public class FastDfsController {

    /*
    * 文件上传
    * */
    @PostMapping
    public Result upload(@RequestParam(value = "file") MultipartFile file) throws  Exception{
        FastDfsFile fastDfsFile=new FastDfsFile(file.getOriginalFilename(),file.getBytes(), StringUtils.getFilenameExtension(file.getOriginalFilename()));
        FastDfsUtil.Upload(fastDfsFile);
        return new Result(true, StatusCode.OK,"上传成功",null);
    }
}
