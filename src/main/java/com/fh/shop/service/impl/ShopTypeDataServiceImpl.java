package com.fh.shop.service.impl;

import com.fh.shop.dao.ShopTypeDataDao;
import com.fh.shop.entity.po.ShopTypeData;
import com.fh.shop.service.ShopTypeDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopTypeDataServiceImpl implements ShopTypeDataService {


    @Resource
    private ShopTypeDataDao shopTypeDataDao;

    @Override
    public List<ShopTypeData> selectTypeDataByShopId(Integer shopId) {

        return shopTypeDataDao.selectTypeDataByShopId(shopId);
    }
}
