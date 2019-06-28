package com.cskaoyan.service.schemedprogress.impl;

import com.cskaoyan.bean.OrderByRevEngineering;
import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.bean.schemedprogress.OrderRow;
import com.cskaoyan.mapper.OrderMapperByRevEngineering;
import com.cskaoyan.mapper.schemedprogress.OrderMapper;
import com.cskaoyan.service.schemedprogress.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderMapperByRevEngineering orderMapperByRevEngineering;

    @Override
    public OrderMangger selectOrdersByPage(String page, String rows) {
        OrderMangger orderMangger = new OrderMangger();
        int count = orderMapper.OrdersCount();
        orderMangger.setTotal(count);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<OrderRow> allOrders = orderMapper.findAllOrders();
        orderMangger.setRows(allOrders);
        return orderMangger;
    }


    @Override
    public OrderMangger selectOrderById(String searchValue, String page, String rows) {
        int count = orderMapper.OrderCountById(Integer.parseInt(searchValue));
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<OrderRow> orderRows = orderMapper.selectOrdersById(Integer.parseInt(searchValue));
        OrderMangger orderMangger = new OrderMangger();
        orderMangger.setTotal(count);
        orderMangger.setRows(orderRows);
        return orderMangger;
    }

    @Override
    public OrderMangger selectOrderByCustom(String searchValue, String page, String rows) {
        int count = orderMapper.OrderCountByCustom(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<OrderRow> orderRows = orderMapper.selectOrdersBCustom(searchValue);
        OrderMangger orderMangger = new OrderMangger();
        orderMangger.setTotal(count);
        orderMangger.setRows(orderRows);
        return orderMangger;
    }

    @Override
    public OrderMangger selectOrderByProduct(String searchValue, String page, String rows) {
        int count = orderMapper.OrderCountByProduct(searchValue);
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        List<OrderRow> orderRows = orderMapper.selectOrdersByProduct(searchValue);
        OrderMangger orderMangger = new OrderMangger();
        orderMangger.setTotal(count);
        orderMangger.setRows(orderRows);
        return orderMangger;
    }

    @Override
    public int deleteByIds(String[] ids) {
        int i = orderMapper.deleteByIds(ids);

        return i;
    }

    @Override
    public int insert(OrderByRevEngineering order) {
        int insert = orderMapperByRevEngineering.insert(order);
        return insert;
    }

    @Override
    public int update(OrderByRevEngineering order) {
        int update = orderMapperByRevEngineering.updateByPrimaryKey(order);
        return update;
    }

    @Override
    public OrderByRevEngineering getById(String oid) {
        OrderByRevEngineering orderByRevEngineering = orderMapperByRevEngineering.selectByPrimaryKey(oid);
        return orderByRevEngineering;
    }
}
