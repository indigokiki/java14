package com.cskaoyan.service.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.bean.material.MaterialConsume;

import java.util.List;
import java.util.Map;

public interface MaterialService {
    List<Material> queryMaterialList();
    Map<String,Object> allMaterialReceives();
    Map<String,Object> allMaterialConsumes();
    List<MaterialConsume> queryMaterialConsumeList();


}
