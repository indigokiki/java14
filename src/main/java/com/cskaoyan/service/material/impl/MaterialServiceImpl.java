package com.cskaoyan.service.material.impl;

import com.cskaoyan.bean.material.*;
import com.cskaoyan.mapper.material.MaterialConsumeMapper;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.mapper.material.MaterialReceiveMapper;
import com.cskaoyan.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServiceImpl implements MaterialService {
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
    public Map<String, Object> allMaterialReceives() {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        List<MaterialReceives> materialReceives = materialMapper.allMaterialReceives();
        long l = materialReceiveMapper.countByExample(materialReceiveExample);
        Map<String, Object> map = new HashMap<>();
        map.put("total",l);
        map.put("rows",materialReceives);
        return map;
        /*
        MaterialReceiveExample.Criteria criteria = materialReceiveExample.createCriteria();


       */
    }

    @Override
    public Map<String, Object> allMaterialConsumes() {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        List<MaterialConsumes> materialConsumes = materialMapper.allMaterialConsumes();
        long l = materialConsumeMapper.countByExample(materialConsumeExample);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",l);
        map.put("rows",materialConsumes);
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
