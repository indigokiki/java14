package com.cskaoyan.mapper;

import com.cskaoyan.bean.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> findAllOrders(@Param("limit") int limit, @Param("offset") int offset);

    int OrdersCount();
}
