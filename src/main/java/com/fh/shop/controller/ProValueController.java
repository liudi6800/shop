package com.fh.shop.controller;

import com.fh.shop.entity.po.ProValue;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.service.ProValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/proValue/")
public class ProValueController {

    @Autowired
    private ProValueService proValueService;

    @GetMapping("selectProValueByproId")
    public ResponseData selectProValueByproId(Integer proId){
        if(proId==null){
            return ResponseData.error(400,"非法请求");
        }
       List<ProValue>list= proValueService.selectProValueByproId(proId);

        return ResponseData.success(list);
    }



}
