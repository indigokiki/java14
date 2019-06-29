package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.bean.material.MaterialReceiveExample;
import com.cskaoyan.bean.material.MaterialReceives;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {

    List<MaterialReceives> allMaterialReceives();

    List<MaterialReceives> searchMaterialReceiveByReceiveId(@Param("searchValue") String value);
    List<MaterialReceives> searchMaterialReceiveByMaterialId(@Param("searchValue") String value);

    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);
}