package com.fh.shop.service;

import com.fh.shop.entity.po.ShopTypeData;

import java.util.List;

public interface ShopTypeDataService {
    List<ShopTypeData> selectTypeDataByShopId(Integer shopId);
}
