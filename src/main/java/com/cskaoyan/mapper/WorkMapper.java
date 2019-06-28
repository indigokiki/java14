package com.cskaoyan.mapper;

import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.WorkExample;
import com.cskaoyan.bean.schemedprogress.WorkRow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    List<WorkRow> getAllWorkByPage();

    int getCountWork();
}