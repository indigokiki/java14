package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.schemedprogress.ManufactureMagger;
import com.cskaoyan.bean.schemedprogress.ManufactureRow;

import java.util.List;

public interface ManufactureService {

    ManufactureMagger getManufactureByPage(String page, String rows);

    int insert(Manufacture manufacture);

    int update(Manufacture manufacture);

    int delete(String[] ids);

    ManufactureMagger search_manufacture_by_manufactureSn(String searchValue, String page, String rows);

    ManufactureMagger search_manufacture_by_manufactureOrderId(String searchValue, String page, String rows);

    ManufactureMagger search_manufacture_by_manufactureTechnologyName(String searchValue, String page, String rows);

    List<Manufacture> getAllManufactures();
}
