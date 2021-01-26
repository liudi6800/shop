package com.fh.shop.controller;

import com.fh.shop.entity.po.ProValue;
import com.fh.shop.entity.vo.ResponseData;
import com.fh.shop.service.ProValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/proValue/")
public class ProValueController {

    @Autowired
    private ProValueService proValueService;


    /*
    *
    *
    *
    *   /*
     * 接口   http://192.168.1.224:8083/api/proValue/selectProValueByproId
     *
     * 参数  proId  必传
     *
     * */



    @GetMapping("selectProValueByproId")
    public ResponseData selectProValueByproId(Integer proId){
        if(proId==null){
            return ResponseData.error(400,"非法请求");
        }
       List<ProValue>list= proValueService.selectProValueByproId(proId);

        return ResponseData.success(list);
    }


    /*
     *
     *
     *
     *
     * 接口   http://192.168.1.224:8083/api/proValue/addProValue
     *
     * 参数  proValue  必传
     *
     * */
    @PostMapping("addProValue")
    public ResponseData addProValue(ProValue proValue){
        proValueService.addProValue(proValue);
        return ResponseData.success(null);
    }

    /*
     *
     *
     *
     *
     * 接口   http://192.168.1.224:8083/api/proValue/updateProValue
     *
     * 参数  proValue  必传
     *
     * */
    @PostMapping("updateProValue")
    public ResponseData updateProValue(ProValue proValue){
        proValueService.updateProValue(proValue);
        return ResponseData.success(null);
    }

    /*
     *
     *
     * 接口   http://192.168.1.224:8083/api/proValue/delProValue
     *
     * 参数  id  必传
     *
     * */
    @DeleteMapping("delProValue")
    public ResponseData d1elProValue(Integer  id){
        if(id==null){
            return ResponseData.error(400,"非法参数");
        }
        proValueService.delProValue(id);
        return ResponseData.success(null);
    }
}
