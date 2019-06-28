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
    @Autowired
    MaterialReceiveMapper materialReceiveMapper;
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public List<Material> findAllMaterial() {
        MaterialExample materialExample = new MaterialExample();
        List<Material> materials = materialMapper.selectByExample(materialExample);
        return materials;
    }

    //物料信息分页查询
    @Override
    public Page<Material> selectMaterialPage(int page, int rows) {
        Page<Material> selectMaterialPage = new Page<>();
        MaterialExample materialExample = new MaterialExample();
        PageHelper.startPage(page,rows);

        List<Material> materials = materialMapper.selectByExample(materialExample);
        selectMaterialPage.setRows(materials);
        int l = (int)materialMapper.countByExample(materialExample);
        selectMaterialPage.setTotal(l);

        return selectMaterialPage;
    }
    //物料收入分页查询
    @Override
    public Page<MaterialReceives> selectMaterialReceivesPage(int page, int rows) {
        Page<MaterialReceives> selectMaterialReceivesPage = new Page<>();
        PageHelper.startPage(page,rows);
       // MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        List<MaterialReceives> materialReceives = materialReceiveMapper.allMaterialReceives();
        selectMaterialReceivesPage.setRows(materialReceives);
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        int l = (int)materialReceiveMapper.countByExample(materialReceiveExample);
        selectMaterialReceivesPage.setTotal(l);
        return selectMaterialReceivesPage;
    }
    //物料消耗分页查询
    @Override
    public Page<MaterialConsumes> selectMaterialConsumesPage(int page, int rows) {
        Page<MaterialConsumes> selectMaterialConsumesPage = new Page<>();
        PageHelper.startPage(page,rows);
        List<MaterialConsumes> materialConsumes = materialConsumeMapper.allMaterialConsumes();
        selectMaterialConsumesPage.setRows(materialConsumes);
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        int l =(int) materialConsumeMapper.countByExample(materialConsumeExample);
        selectMaterialConsumesPage.setTotal(l);
        return selectMaterialConsumesPage;
    }


    //物料信息新增
    @Override
    public int insertMaterial(Material material) {
        int insert = materialMapper.insert(material);
        return insert;
    }
    //物料信息删除
    @Override
    public int deleteMaterials(String id) {
        int i = materialMapper.deleteByPrimaryKey(id);
        return i;
    }
    //物料信息编辑
    @Override
    public int updateMaterial(Material material) {
        MaterialExample materialExample = new MaterialExample();
        int i1 = materialMapper.updateByPrimaryKey(material);
       return i1;
    }
    //物料信息搜索-物料编号
    @Override
    public Page<Material> searchMaterialById(String searchValue, int page, int rows) {
        Page<Material> materialPage = new Page<>();
        PageHelper.startPage(page,rows);
        String value = "%"+searchValue+"%";
        MaterialExample materialExample = new MaterialExample();
        materialExample.createCriteria().andMaterialIdLike(value);
        List<Material> materials = materialMapper.selectByExample(materialExample);
        materialPage.setRows(materials);
        int l = (int)materialMapper.countByExample(materialExample);
        materialPage.setTotal(l);
        return materialPage;
    }
    //物料信息搜索-物料类型
    @Override
    public Page<Material> searchMaterialByType(String searchValue, int page, int rows) {
        Page<Material> materialPage = new Page<>();
        PageHelper.startPage(page,rows);
        String value = "%"+searchValue+"%";
        MaterialExample materialExample = new MaterialExample();
        materialExample.createCriteria().andMaterialTypeLike(value);
        List<Material> materials = materialMapper.selectByExample(materialExample);
        materialPage.setRows(materials);
        int l = (int)materialMapper.countByExample(materialExample);
        materialPage.setTotal(l);
        return materialPage;
    }
    //物料收入新增
    @Override
    public int insertMaterialReceive(MaterialReceive materialReceive) {
        int insert = materialReceiveMapper.insertSelective(materialReceive);
        return insert;
    }
    //物料收入删除
    @Override
    public int deleteMaterialReceive(String id) {
        int i = materialReceiveMapper.deleteByPrimaryKey(id);
        return i;
    }
    //物料收入编辑
    @Override
    public int updateMaterialReceive(MaterialReceive materialReceive) {
       // MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        int i = materialReceiveMapper.updateByPrimaryKey(materialReceive);
        return i;
    }
    //物料收入搜索-物料收入编号
    @Override
    public Page<MaterialReceives> searchMaterialReceiveByReceiveId(String searchValue, int page, int rows) {
        Page<MaterialReceives> materialReceivesPage = new Page<>();
        PageHelper.startPage(page,rows);
        String value = "%"+searchValue+"%";
        List<MaterialReceives> materialReceives = materialReceiveMapper.searchMaterialReceiveByReceiveId(value);
        materialReceivesPage.setRows(materialReceives);

        /*MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        int l =(int) materialReceiveMapper.countByExample(materialReceiveExample);*/
        materialReceivesPage.setTotal(materialReceiveMapper.searchMaterialReceiveByReceiveId(value).size());
        return materialReceivesPage;
    }

        //物料收入搜索-物料编号
    @Override
    public Page<MaterialReceives> searchMaterialReceiveByMaterialId(String searchValue, int page, int rows) {
        Page<MaterialReceives> materialReceivePage = new Page<>();
        PageHelper.startPage(page,rows);
        String value = "%"+searchValue+"%";
        List<MaterialReceives> materialReceives = materialReceiveMapper.searchMaterialReceiveByMaterialId(value);

        materialReceivePage.setRows(materialReceives);

        /*MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        int l =(int) materialReceiveMapper.countByExample(materialReceiveExample);*/

        materialReceivePage.setTotal(materialReceiveMapper.searchMaterialReceiveByMaterialId(value).size());
        return materialReceivePage;
    }

    @Override
    public int insertMaterialConsume(MaterialConsume materialConsume) {
        int i = materialConsumeMapper.insertSelective(materialConsume);
        return i;
    }

    @Override
    public int deleteMaterialConsume(String id) {
        int i = materialConsumeMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int updateMaterialConsume(MaterialConsume materialConsume) {
        //MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        int i = materialConsumeMapper.updateByPrimaryKey(materialConsume);
        return i;
    }

    @Override
    public Page<MaterialConsumes> searchMaterialReceiveByConsumeId(String searchValue, int page, int rows) {
        Page<MaterialConsumes> materialConsumePage = new Page<>();
        PageHelper.startPage(page,rows);
        String value = "%"+searchValue+"%";

        List<MaterialConsumes> materialConsumes = materialConsumeMapper.searchMaterialReceiveByConsumeId(value);
        /*MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        materialConsumeExample.createCriteria().andConsumeIdLike(value);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByExample(materialConsumeExample);*/
        materialConsumePage.setRows(materialConsumes);
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        int l = (int)materialConsumeMapper.countByExample(materialConsumeExample);
        materialConsumePage.setTotal(l);
        return materialConsumePage;
    }

    @Override
    public Page<MaterialConsumes> searchMaterialConsumeByMaterialId(String searchValue, int page, int rows) {
        Page<MaterialConsumes> materialConsumePage = new Page<>();
        PageHelper.startPage(page,rows);
        String value = "%"+searchValue+"%";

        List<MaterialConsumes> materialConsumes = materialConsumeMapper.searchMaterialConsumeByMaterialId(value);
        //MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        //materialConsumeExample.createCriteria().andMaterialIdLike(value);
        //List<MaterialConsumes> materialConsumes = materialConsumeMapper.selectByExample(materialConsumeExample);
        materialConsumePage.setRows(materialConsumes);
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        int l = (int)materialConsumeMapper.countByExample(materialConsumeExample);
        materialConsumePage.setTotal(l);
        return materialConsumePage;
    }

    @Override
    public Page<MaterialConsumes> searchMaterialConsumeByWorkId(String searchValue, int page, int rows) {
        Page<MaterialConsumes> materialConsumePage = new Page<>();
        PageHelper.startPage(page,rows);
        String value = "%"+searchValue+"%";

        List<MaterialConsumes> materialConsumes = materialConsumeMapper.searchMaterialConsumeByWorkId(value);
        //MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
       // materialConsumeExample.createCriteria().andWorkIdLike(value);
       // List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByExample(materialConsumeExample);
        materialConsumePage.setRows(materialConsumes);
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        int l = (int)materialConsumeMapper.countByExample(materialConsumeExample);
        materialConsumePage.setTotal(l);
        return materialConsumePage;
    }

    @Override
    public Material selectOneMaterial(String materialId) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material;
    }

    @Override
    public int updateMaterialDetail(String materialId, String note) {
        Material material = new Material(materialId,note);
        int i = materialMapper.updateByPrimaryKeySelective(material);
        return i;
    }

    @Override
    public int updateMaterialReceiveDetail(String receiveId, String note) {
        MaterialReceive materialReceive = new MaterialReceive(receiveId,note);
        int i = materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
        return i;
    }

    @Override
    public int updateMaterialConsumeDetail(String consumeId, String note) {
        MaterialConsume materialConsume = new MaterialConsume(consumeId,note);
        int i = materialConsumeMapper.updateByPrimaryKeySelective(materialConsume);
        return i;
    }
}
