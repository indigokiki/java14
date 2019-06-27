package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.schemedprogress.ManufactureMagger;

public interface ManufactureService {

    ManufactureMagger getManufactureByPage(String page, String rows);
}
