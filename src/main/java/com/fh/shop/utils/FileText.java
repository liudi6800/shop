package com.fh.shop.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

public class FileText {


    public static String saveFile(MultipartFile file) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GJs4jmAirJGGQQcK7FK";
        String accessKeySecret = "2CXp2A5GIpddPrywh9VRqK72Mnvuwu";
        String bucketName = "imagestext";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


        //获取上传文件的名 aaa.jpg  bbb.xlsx  cccc.zip
        String fileName = file.getOriginalFilename();
        //起新名
        String newName= UUID.randomUUID().toString();
        //处理文件格式
        String fileType=fileName.substring(fileName.lastIndexOf("."));
        String newFileName=newName+fileType;
        String images="";
            try {
                InputStream is = file.getInputStream();

                // 创建PutObjectRequest对象。
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, newFileName, is);

                // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
                  ObjectMetadata metadata = new ObjectMetadata();
                  metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
                  metadata.setObjectAcl(CannedAccessControlList.PublicRead);
                  putObjectRequest.setMetadata(metadata);

                // 上传文件。
                 ossClient.putObject(putObjectRequest);
                Date expiration = new Date(System.currentTimeMillis() + 10 * 365 * 24 * 60 * 60 * 1000);
                URL url = ossClient.generatePresignedUrl(bucketName, newFileName, expiration);
                String[] split = url.toString().split("\\?");
                images =split[0];
                // 关闭OSSClient。
                ossClient.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }


                return images;

    }



}
