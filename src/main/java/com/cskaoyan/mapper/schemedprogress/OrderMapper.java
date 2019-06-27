package com.cskaoyan.mapper.schemedprogress;

import com.cskaoyan.bean.schemedprogress.Order;
import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.bean.schemedprogress.OrderRow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<OrderRow> findAllOrders();

    int OrdersCount();

    List<OrderRow> selectOrdersById(@Param("id") int id);

    int OrderCountById(@Param("id") int id);

    List<OrderRow> selectOrdersBCustom(@Param("customName") String customName);

    int OrderCountByCustom(@Param("customName") String customName);

    List<OrderRow> selectOrdersByProduct(@Param("productName") String productName);

    int OrderCountByProduct(@Param("productName") String productName);

    List<Order> getOrderData();

}
