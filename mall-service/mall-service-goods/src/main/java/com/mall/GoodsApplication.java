package com.mall;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient  //开启eureka客户端
@MapperScan(basePackages="com.mall.goods.dao")    //开始mapper扫描
public class GoodsApplication {

    public static void main(String args[]){
        SpringApplication.run(GoodsApplication.class,args);
    }
}
