package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
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
        manufactureMagger.setTotal(count);
        manufactureMagger.setRows(allManufactureByPage);
        return manufactureMagger;
    }

    @Override
    public int insert(Manufacture manufacture) {
        int insert = manufactureMapper.insert(manufacture);
        return insert;
    }

    @Override
    public int update(Manufacture manufacture) {
        int update = manufactureMapper.updateByPrimaryKey(manufacture);
        return update;
    }

    @Override
    public int delete(String[] ids) {
        int status = 1;
        for (String id : ids) {
            int delete = manufactureMapper.deleteByPrimaryKey(id);
            if(delete == 0){
                status = 0;
            }
        }

        return status;
    }

    @Override
    public ManufactureMagger search_manufacture_by_manufactureSn(String searchValue, String page, String rows) {
        List<ManufactureRow> manufactureRows = manufactureMapper.search_manufacture_by_manufactureSn(searchValue);
        int count = manufactureMapper.count_search_manufacture_by_manufactureSn(searchValue);
        ManufactureMagger manufactureMagger = new ManufactureMagger();
        manufactureMagger.setRows(manufactureRows);
        manufactureMagger.setTotal(count);
        return manufactureMagger;
    }

    @Override
    public ManufactureMagger search_manufacture_by_manufactureOrderId(String searchValue, String page, String rows) {
        List<ManufactureRow> manufactureRows = manufactureMapper.search_manufacture_by_manufactureOrderId(searchValue);
        int count = manufactureMapper.count_search_manufacture_by_manufactureOrderId(searchValue);
        ManufactureMagger manufactureMagger = new ManufactureMagger();
        manufactureMagger.setRows(manufactureRows);
        manufactureMagger.setTotal(count);
        return manufactureMagger;
    }

    @Override
    public ManufactureMagger search_manufacture_by_manufactureTechnologyName(String searchValue, String page, String rows) {
        List<ManufactureRow> manufactureRows = manufactureMapper.search_manufacture_by_manufactureTechnologyName(searchValue);
        int count = manufactureMapper.count_search_manufacture_by_manufactureTechnologyName(searchValue);
        ManufactureMagger manufactureMagger = new ManufactureMagger();
        manufactureMagger.setRows(manufactureRows);
        manufactureMagger.setTotal(count);
        return manufactureMagger;
    }

    @Override
    public List<Manufacture> getAllManufactures() {
        ManufactureExample manufactureExample = new ManufactureExample();
        List<Manufacture> manufactures = manufactureMapper.selectByExample(manufactureExample);
        return manufactures;
    }
}
