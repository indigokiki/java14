package com.cskaoyan.service.material;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.material.*;

import java.util.List;
import java.util.Map;

public interface MaterialService {

    //物料模塊信息获取及展示
    List<Material> findAllMaterial();
    Page<Material> selectMaterialPage(int page, int rows);
     Page<MaterialReceives> selectMaterialReceivesPage(int page, int rows);
     Page<MaterialConsumes> selectMaterialConsumesPage(int page, int rows);

     //物料收入增刪改查
     int insertMaterial(Material material);
     int deleteMaterials(String id);
     int updateMaterial(Material material);
    Page<Material> searchMaterialById(String searchValue,int page,int rows);
    Page<Material> searchMaterialByType(String searchValue,int page,int rows);

    //物料收入增刪改查
    int insertMaterialReceive(MaterialReceive materialReceive);
    int deleteMaterialReceive(String id);
    int updateMaterialReceive(MaterialReceive materialReceive);
    Page<MaterialReceives> searchMaterialReceiveByReceiveId(String searchValue,int page,int rows);
    Page<MaterialReceives> searchMaterialReceiveByMaterialId(String searchValue,int page,int rows);

    //物料消耗增刪改查
    int insertMaterialConsume(MaterialConsume materialConsume);
    int deleteMaterialConsume(String id);
    int updateMaterialConsume(MaterialConsume materialConsume);
    Page<MaterialConsumes> searchMaterialReceiveByConsumeId(String searchValue,int page,int rows);
    Page<MaterialConsumes>searchMaterialConsumeByMaterialId (String searchValue,int page,int rows);
    Page<MaterialConsumes>searchMaterialConsumeByWorkId (String searchValue,int page,int rows);

    //物料详情获取
     Material  selectOneMaterial(String materialId);
     //物料详情更改
    int updateMaterialDetail(String materialId,String note);


    int updateMaterialReceiveDetail(String receiveId,String note);
    int updateMaterialConsumeDetail(String consumeId,String note);
}
