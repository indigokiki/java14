package com.cskaoyan.service.material.impl;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.material.*;
import com.cskaoyan.mapper.material.MaterialConsumeMapper;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.mapper.material.MaterialReceiveMapper;
import com.cskaoyan.service.material.MaterialService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    //物料信息分页查询
    @Override
    public Page<Material> selectMaterialPage(int page, int rows) {
        Page<Material> selectMaterialPage = new Page<>();
        PageHelper.startPage(page,rows);
        MaterialExample materialExample = new MaterialExample();
        List<Material> materials = materialMapper.selectByExample(materialExample);
        selectMaterialPage.setRows(materials);
        selectMaterialPage.setTotal(materials.size());
        return selectMaterialPage;
    }
    //物料收入分页查询
    @Override
    public Page<MaterialReceives> selectMaterialReceivesPage(int page, int rows) {
        Page<MaterialReceives> selectMaterialReceivesPage = new Page<>();
        PageHelper.startPage(page,rows);
       // MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        List<MaterialReceives> materialReceives = materialMapper.allMaterialReceives();
        selectMaterialReceivesPage.setRows(materialReceives);
        selectMaterialReceivesPage.setTotal(materialReceives.size());
        return selectMaterialReceivesPage;
    }
    //物料消耗分页查询
    @Override
    public Page<MaterialConsumes> selectMaterialConsumesPage(int page, int rows) {
        Page<MaterialConsumes> selectMaterialConsumesPage = new Page<>();
        PageHelper.startPage(page,rows);
        List<MaterialConsumes> materialConsumes = materialMapper.allMaterialConsumes();
        selectMaterialConsumesPage.setRows(materialConsumes);
        selectMaterialConsumesPage.setTotal(materialConsumes.size());
        return selectMaterialConsumesPage;
    }
    //物料信息新增
    @Override
    public int insertMaterial(Material material) {
        MaterialExample materialExample = new MaterialExample();
        int insert = materialMapper.insert(material);
        return insert;
    }

    @Override
    public int deleteMaterials(String id) {
        MaterialExample materialExample = new MaterialExample();
        int i = materialMapper.deleteByPrimaryKey(id);
        return i;
    }
}
