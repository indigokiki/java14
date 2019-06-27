package com.cskaoyan.mapper;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.bean.TechnologyRequirementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);
    //新增
    List<TechnologyRequirement> selectAll();
    //新增
    List<TechnologyRequirement> selectAllWithTechnologyName();
    //新增
    List<TechnologyRequirement> selectTechReqByTechnologyId(@Param("technologyId") String technologyId);
    //新增，用于搜索
    TechnologyRequirement selectByPrimaryKeyWithTechName(@Param("technologyRequirementId") String technologyRequirementId);

}