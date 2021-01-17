package com.fh.shop.controller;

import com.fh.shop.entity.po.ShopBrand;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.entity.vo.ShopBrandParms;
import com.fh.shop.service.ShopBrandService;
import com.fh.shop.utils.FileInput;
import com.fh.shop.utils.FileText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;


@RestController
@CrossOrigin
@RequestMapping("api/brand/")
public class ShopBrandController {


    @Autowired
    private ShopBrandService shopBrandService;

    @Resource
    private HttpServletRequest request;

/*
*
*
*
*
*
* */

    @GetMapping("getData")
    public ResponseData getData(ShopBrandParms parms){
        if(parms.getPage()==null){
            return ResponseData.error(400,"非法请求");
        }
        if(parms.getLimit()==null){
            return ResponseData.error(400,"非法请求");
        }
        Map map=shopBrandService.getData(parms);
        return ResponseData.success(map);
    }

    @PostMapping("add")
    public ResponseData addShopBrand(ShopBrand shopBrand){

        shopBrandService.addShopBrand(shopBrand);
        return ResponseData.success(null);
    }


    @PostMapping("update")
    public ResponseData updateShopBrand(ShopBrand shopBrand){

        shopBrandService.updateShopBrand(shopBrand);
        return ResponseData.success(null);
    }

    @RequestMapping("uploadImgPath")
    public ResponseData uploadImgPath(MultipartFile file) throws IOException {

        //获取上传文件的名 aaa.jpg  bbb.xlsx  cccc.zip
        String fileName = file.getOriginalFilename();
        //起新名
        String newName= UUID.randomUUID().toString();
        //处理文件格式
        String fileType=fileName.substring(fileName.lastIndexOf("."));
        String newFileName=newName+fileType;
        newFileName="img"+"/"+newFileName;
        String images = FileText.saveFile(file.getInputStream(),newFileName);
        return ResponseData.success(images);
    }
}
