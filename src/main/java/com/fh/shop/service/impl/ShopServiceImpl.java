package com.fh.shop.service.impl;

import com.fh.shop.dao.ShopDao;
import com.fh.shop.entity.po.Shop;
import com.fh.shop.entity.vo.ShopParms;
import com.fh.shop.service.ShopService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;


    @Override
    public Map selectShop(ShopParms parms) {
        Map map=new HashMap();
        Long aLong = shopDao.selectShopCount(parms);
        parms.setStartIndex((parms.getPage()-1)*parms.getLimit());
        List<Shop> shops = shopDao.selectShopData(parms);
        map.put("count",aLong);
        map.put("data",shops);
        return map;
    }

    @Override
    public void addShop(Shop shop) {
        Date now=new Date();
        shop.setCreateDate(now);
        shop.setUpdateDate(now);
        shopDao.addShop(shop);
    }

    @Override
    public void updateShop(Shop shop) {
        Date now=new Date();
        shop.setUpdateDate(now);
        shopDao.updataShop(shop);
    }

    @Override
    public void delShop(Integer isDel, Integer id) {
        Map map=new HashMap();
        map.put("isDel",isDel);
        map.put("id",id);
        shopDao.delShop(map);

    }
}
