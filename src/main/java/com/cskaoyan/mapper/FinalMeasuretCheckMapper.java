package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.FinalMeasuretCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalMeasuretCheckMapper {
    long countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> getFinalMeasuretCheckList();

    int getFinalMeasuretCheckNum();

    List<FinalMeasuretCheck> selectFinalMeasuretCheckListByOrderId(@Param("orderId") String orderId);

    int countFinalMeasuretCheckListByOrderId(@Param("orderId")String orderId);
}