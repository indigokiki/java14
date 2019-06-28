package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.FinalCountCheckExample;
import org.apache.ibatis.annotations.Param;
import sun.security.krb5.internal.ccache.FileCCacheConstants;

import java.util.List;

public interface FinalCountCheckMapper {
    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    List<FinalCountCheck> getFinalCountCheckList();

    int getFinalCountCheckNum();

    List<FinalCountCheck> selectFinalCountCheckListByOrderId(@Param("orderId") String orderId);

    int countFinalCountCheckListByOrderId(@Param("orderId") String orderId);
}