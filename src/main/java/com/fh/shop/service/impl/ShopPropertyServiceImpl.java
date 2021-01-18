package com.fh.shop.service.impl;

import com.fh.shop.dao.ShopPropertyDao;
import com.fh.shop.entity.po.ShopProperty;
import com.fh.shop.entity.vo.ShopPropertyParms;
import com.fh.shop.service.ShopPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopPropertyServiceImpl implements ShopPropertyService {

    @Resource
    private ShopPropertyDao shopPropertyDao;

    @Override
    public Map selectShopPropertyByParma(ShopPropertyParms parms) {
        Map map=new HashMap();
        Integer count = shopPropertyDao.selectShopPropertyCount(parms);
        parms.setStartIndex((parms.getPage()-1)*parms.getLimit());
        List<ShopProperty> shopProperties = shopPropertyDao.selectShopPropertyData(parms);
        map.put("count",count);
        map.put("data",shopProperties);
        return map;
    }

    @Override
    public void addShopProperty(ShopProperty shopProperty) {
        shopProperty.setIsDel(0);
        shopProperty.setCreateDate(new Date());
        shopPropertyDao.addShopProperty(shopProperty);
    }

    @Override
    public void updateShopProperty(ShopProperty shopProperty) {
        shopProperty.setUpdateDate(new Date());
        shopPropertyDao.updateShopProperty(shopProperty);
    }

    @Override
    public void deleteShopPropertyById(Integer id, Integer isDel) {
        Map map=new HashMap();
        map.put("id",id);
        map.put("isDel",isDel);
        shopPropertyDao.deleteShopPropertyById(map);
    }
}
