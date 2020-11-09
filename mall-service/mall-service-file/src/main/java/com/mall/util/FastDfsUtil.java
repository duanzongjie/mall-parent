package com.mall.util;

import com.mall.file.FastDfsFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/*
* 实现FastDFS文件管理
* 上传
* 下载
* 删除
* 文件信息获取
*
* */
public class FastDfsUtil {

    /*
    * tracker 连接信息
    *
    * */

    static {
        try{
         //加载配置classPath地址下文件的路径
         String fileName=new ClassPathResource("fastdfs_client.conf").getPath();
         //加载tracker连接信息
         ClientGlobal.init(fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /*
    文件上传
    */

    public  static void Upload(FastDfsFile fastDfsFile) throws Exception{

        //创建tracker访问的客户端对象trackerClient
        TrackerClient trackerClient=new TrackerClient();

        //通过trackerClient访问trackerServer获得可以使用的连接信息
        TrackerServer trackerServer=trackerClient.getConnection();
        //通过trackerServer的连接信息可以获取StorageClient的连接信息,并且创建客户端
        StorageClient storageClient=new StorageClient(trackerServer,null);
        //StroageClient 访问Storage，实现文件上传，并且返回存储信息
        //附加信息
        NameValuePair[] nameValuePairs=new NameValuePair[1];
        nameValuePairs[0]=new NameValuePair("author",fastDfsFile.getAuthor());
        storageClient.upload_file(fastDfsFile.getContent(),fastDfsFile.getExt(),null);
    }
}
