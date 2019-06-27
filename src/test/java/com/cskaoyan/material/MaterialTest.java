package com.cskaoyan.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.bean.material.MaterialExample;
import com.cskaoyan.bean.material.MaterialReceiveExample;
import com.cskaoyan.bean.material.MaterialReceives;
import com.cskaoyan.mapper.material.MaterialMapper;
import com.cskaoyan.service.material.MaterialService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @Author IL-M
 * @Date:2019/6/27 16:02
 */
public class MaterialTest {
    @Autowired
    MaterialService materialService;
    @Test
    public void mytest(){
        List<Material> materials = materialService.queryMaterialList();
        System.out.println(materials);
    }

    @Autowired
    MaterialMapper materialMapper;
    @Test
    public void mytest2(){
        //List<MaterialReceives> materialReceives = materialMapper.allMaterialReceives();
        MaterialExample materialExample = new MaterialExample();

        long l = materialMapper.countByExample(materialExample);
        System.out.println(l);
        //System.out.println(materialReceives);
    }
}
