package com.cskaoyan.mapper;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.ManufactureExample;
import com.cskaoyan.bean.schemedprogress.ManufactureRow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<ManufactureRow> getAllManufactureByPage();

    int getCountManufacture();

    int insertManufactureRow(@Param("manu") ManufactureRow manu);

    List<ManufactureRow> search_manufacture_by_manufactureSn(@Param("mid") String mid);

    int count_search_manufacture_by_manufactureSn(@Param("mid") String mid);

    List<ManufactureRow> search_manufacture_by_manufactureOrderId(@Param("oid") String oid);

    int count_search_manufacture_by_manufactureOrderId(@Param("oid") String oid);

    List<ManufactureRow> search_manufacture_by_manufactureTechnologyName(@Param("tnamae") String tnamae);

    int count_search_manufacture_by_manufactureTechnologyName(@Param("tnamae") String tnamae);
}