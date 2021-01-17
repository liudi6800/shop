package com.fh.shop.service;

import com.fh.shop.entity.po.ProValue;

import java.util.List;

public interface ProValueService {

    List<ProValue> selectProValueByproId(Integer id);

    void addProValue(ProValue proValue);
}
