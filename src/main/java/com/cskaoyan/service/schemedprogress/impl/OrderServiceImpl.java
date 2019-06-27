/*package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.mapper.schemedprogress.OrderMapper;
import com.cskaoyan.service.schemedprogress.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderMangger selectOrdersByPage() {
        OrderMangger orderMangger = new OrderMangger();
        orderMangger.setTotal(orderMapper.OrdersCount());
        orderMangger.setRows(orderMapper.findAllOrders());
        return orderMangger;
    }
}*/
