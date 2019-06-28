package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.schemedprogress.ManufactureMagger;
import com.cskaoyan.bean.schemedprogress.ManufactureRow;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.service.schemedprogress.ManufactureService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureMapper manufactureMapper;

    @Override
    public ManufactureMagger getManufactureByPage(String page, String rows) {
        int count = manufactureMapper.getCountManufacture();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<ManufactureRow> allManufactureByPage = manufactureMapper.getAllManufactureByPage();
        ManufactureMagger manufactureMagger = new ManufactureMagger();
        manufactureMagger.setTotll(count);
        manufactureMagger.setManufactureRows(allManufactureByPage);
        return manufactureMagger;
    }
}
