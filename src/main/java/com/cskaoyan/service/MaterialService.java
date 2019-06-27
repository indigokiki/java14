package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.MaterialReceive;

import java.util.List;
import java.util.Map;

public interface MaterialService {
    List<Material> queryMaterialList();
    Map<String,Object> queryMaterialReceiveList();
    List<MaterialConsume> queryMaterialConsumeList();
}
