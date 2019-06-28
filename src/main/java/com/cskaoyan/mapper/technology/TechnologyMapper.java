package com.cskaoyan.mapper.technology;

import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.bean.technology.TechnologyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyMapper {
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
    //新增
    List<Technology> selectAll();
    //新增
    String selectTechnologyNameById(@Param("technology_id") String technologyId);
    //新增
    List<String> selectTechnologyIdByName(@Param("technologyName") String technologyName);


}