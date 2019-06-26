package com.cskaoyan.service;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.MaterialConsumeMapper;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.mapper.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServiceImpl implements MaterialService{
    @Autowired
    MaterialMapper materialMapper;
    @Override
    public List<Material> queryMaterialList() {
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();

        return materialMapper.selectByExample(materialExample);
    }

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;
    @Override
    public Map<String, Object> queryMaterialReceiveList() {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        MaterialReceiveExample.Criteria criteria = materialReceiveExample.createCriteria();

        List<MaterialReceive> materialReceives = materialReceiveMapper.selectByExample(materialReceiveExample);
        Map<String, Object> map = new HashMap<>();
        map.put("total",5);
        map.put("rows",materialReceives);
        return map;
    }

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;
    @Override
    public List<MaterialConsume> queryMaterialConsumeList() {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        MaterialConsumeExample.Criteria criteria = materialConsumeExample.createCriteria();

        return materialConsumeMapper.selectByExample(materialConsumeExample);
    }
}
