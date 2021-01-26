package com.fh.shop.controller;

import com.fh.shop.entity.po.ShopTypeData;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.service.ShopTypeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("api/shoptypedata")
public class ShopTypeDataController {

    @Autowired
    private ShopTypeDataService shopTypeDataService;

    /*
     *
     *  http://localhost:8083/api/shoptypedata/selectTypeDataByShopId  路径
     *
     * get 请求
     *
     * page  当前页  limit  每页条数   这两个必填项
     *
     *
     * */
    @GetMapping("selectTypeDataByShopId")
    public ResponseData selectTypeDataByShopId(Integer shopId){
        List<ShopTypeData> list=shopTypeDataService .selectTypeDataByShopId(shopId);
        return ResponseData.success(list);
    }





}
