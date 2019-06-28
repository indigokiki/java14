package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.CustomExample;
import com.cskaoyan.bean.schemedprogress.CustomMagger;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.schemedprogress.CustomMaggerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomMaggerServiceImpl implements CustomMaggerService {

    @Autowired
    CustomMapper customMapper;

    @Override
    public CustomMagger selectOrdersByPage(String page, String rows) {
        CustomExample customExample = new CustomExample();
        int count = (int)customMapper.countByExample(customExample);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<Custom> customs = customMapper.selectByExample(customExample);
        CustomMagger customMagger = new CustomMagger();
        customMagger.setTotal(count);
        customMagger.setRows(customs);
        return customMagger;
    }

    @Override
    public List<Custom> selectOrdersById(String cid) {
        CustomExample customExample = new CustomExample();
        CustomExample.Criteria criteria = customExample.createCriteria();
        criteria.andCustomIdEqualTo(cid);
        List<Custom> customs = customMapper.selectByExample(customExample);
        return customs;
    }
}
