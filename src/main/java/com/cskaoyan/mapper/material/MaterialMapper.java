package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.bean.material.MaterialConsumes;
import com.cskaoyan.bean.material.MaterialExample;
import com.cskaoyan.bean.material.MaterialReceives;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MaterialMapper {




    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}