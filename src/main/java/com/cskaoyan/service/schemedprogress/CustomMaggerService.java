package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.schemedprogress.CustomMagger;

import java.util.List;

public interface CustomMaggerService {

    CustomMagger selectOrdersByPage(String page, String rows);

    List<Custom> selectOrdersById(String cid);
}
