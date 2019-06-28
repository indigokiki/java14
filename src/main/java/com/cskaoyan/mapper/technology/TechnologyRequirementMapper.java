package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.TechnologyRequirement;
import com.cskaoyan.bean.technology.TechnologyRequirementExample;
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

    //新增，用于工艺名称搜索功能
    List<TechnologyRequirement> selectByTechnologyIds(@Param("technologyIds") List<String> technologyIds);

}