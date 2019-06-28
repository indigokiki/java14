package com.cskaoyan.service.schemedprogress;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.schemedprogress.CustomMagger;

import java.util.List;

public interface CustomMaggerService {

    CustomMagger selectOrdersByPage(String page, String rows);

    List<Custom> selectOrdersById(String cid);

    int insertCustom(Custom custom);

    int upddateCustom(Custom custom);

    int deleteCustom(String[] ids);

    List<Custom> search_custom_by_customId(String searchValue, String page, String rows);

    List<Custom> search_custom_by_customName(String searchValue, String page, String rows);
}
