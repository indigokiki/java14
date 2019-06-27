package com.cskaoyan.mapper.schemedprogress;

import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.bean.schemedprogress.OrderRow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<OrderRow> findAllOrders();

    int OrdersCount();
}
