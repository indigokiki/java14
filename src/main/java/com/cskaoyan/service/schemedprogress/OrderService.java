package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.OrderByRevEngineering;
import com.cskaoyan.bean.schemedprogress.OrderMangger;

import java.util.List;


public interface OrderService {

    OrderMangger selectOrdersByPage(String page, String rows);


    OrderMangger selectOrderById(String searchValue, String page, String rows);

    OrderMangger selectOrderByCustom(String searchValue, String page, String rows);

    OrderMangger selectOrderByProduct(String searchValue, String page, String rows);

    int deleteByIds(String[] ids);

    int insert(OrderByRevEngineering order);

    int update(OrderByRevEngineering order);

    OrderByRevEngineering getById(String oid);

}
