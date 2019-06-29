package com.cskaoyan.mapper.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialConsumeExample;
import com.cskaoyan.bean.material.MaterialConsumes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialConsumeMapper {

    List<MaterialConsumes> allMaterialConsumes();

    List<MaterialConsumes> searchMaterialReceiveByConsumeId(@Param("searchValue")String value);
    List<MaterialConsumes> searchMaterialConsumeByMaterialId(@Param("searchValue")String value);
    List<MaterialConsumes> searchMaterialConsumeByWorkId(@Param("searchValue")String value);

    long countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);
}