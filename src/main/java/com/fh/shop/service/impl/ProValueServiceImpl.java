package com.fh.shop.service.impl;

import com.fh.shop.dao.ProValueDao;
import com.fh.shop.entity.po.ProValue;
import com.fh.shop.service.ProValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProValueServiceImpl implements ProValueService {

    @Resource
    private ProValueDao proValueDao;


    @Override
    public List<ProValue> selectProValueByproId(Integer id) {

        return proValueDao.selectProValueByproId(id);
    }

    @Override
    public void addProValue(ProValue proValue) {
        proValueDao.addProValue(proValue);
    }

    @Override
    public void updateProValue(ProValue proValue) {
        proValueDao.updateProValue(proValue);
    }

    @Override
    public void delProValue(Integer id) {
        proValueDao.delProValue(id);
    }
}
