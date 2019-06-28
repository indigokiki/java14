package com.cskaoyan.service.material;

import com.cskaoyan.bean.Page;
import com.cskaoyan.bean.material.*;

import java.util.List;
import java.util.Map;

public interface MaterialService {
     Page<Material> selectMaterialPage(int page, int rows);
     Page<MaterialReceives> selectMaterialReceivesPage(int page, int rows);
     Page<MaterialConsumes> selectMaterialConsumesPage(int page, int rows);

     int insertMaterial(Material material);
     int deleteMaterials(String id);


}
