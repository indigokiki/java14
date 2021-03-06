package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyPlanExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TechnologyPlanMapper {
    long countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectAll();

    //新增
    List<TechnologyPlan> selectAllWithTechnologyName();
    //新增
    List<TechnologyPlan> selectByTechnologyIds(@Param("technologyIds") List<String> technologyIds);
}