package com.cskaoyan.mapper;

import com.cskaoyan.bean.OrderByRevEngineering;
import com.cskaoyan.bean.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapperByRevEngineering {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderByRevEngineering record);

    int insertSelective(OrderByRevEngineering record);

    List<OrderByRevEngineering> selectByExample(OrderExample example);

    OrderByRevEngineering selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderByRevEngineering record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") OrderByRevEngineering record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(OrderByRevEngineering record);

    int updateByPrimaryKey(OrderByRevEngineering record);
}