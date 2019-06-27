package com.cskaoyan.mapper.devman;

import com.cskaoyan.bean.devman.Device;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface IDeviceMapper {

    @Select("select * from device")
    @Results({
            @Result(column="device_id", property="deviceId", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="device_name", property="deviceName", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_type_id", property="deviceTypeId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_type_id", property="deviceTypeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_status_id", property="deviceStatusId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_status", property="deviceStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_purchase_date", property="devicePurchaseDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_purchase_price", property="devicePurchasePrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="device_manufacture_date", property="deviceManufactureDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_service_life", property="deviceServiceLife", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_keeper_id", property="deviceKeeper",javaType = String.class,
            one = @One(select="com.cskaoyan.mapper.devman.IEmployeeMapper.findByid")),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    public List<Device> findAll();

    @Select("select device_name from device where device_id=#{id}")
    public String findNameById(String id);

    @Results({
            @Result(column="device_id", property="deviceId", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="device_name", property="deviceName", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_type_id", property="deviceTypeId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_type_id", property="deviceTypeName", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_status_id", property="deviceStatusId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_status", property="deviceStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_purchase_date", property="devicePurchaseDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_purchase_price", property="devicePurchasePrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="device_manufacture_date", property="deviceManufactureDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_service_life", property="deviceServiceLife", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_keeper_id", property="deviceKeeper",javaType = String.class,
                    one = @One(select="com.cskaoyan.mapper.devman.IEmployeeMapper.findByid")),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    @Select("select * from device where device_id like #{id}")
    public List<Device> findById(String id);

    @Insert({
            "insert into device (device_id, device_name, ",
            "device_type_id, device_status_id, ",
            "device_status, device_purchase_date, ",
            "device_purchase_price, device_manufacture_date, ",
            "device_service_life, device_keeper_id, ",
            "note)",
            "values (#{deviceId,jdbcType=VARCHAR}, #{deviceName,jdbcType=VARCHAR}, ",
            "#{deviceTypeId,jdbcType=VARCHAR}, #{deviceStatusId,jdbcType=VARCHAR}, ",
            "#{deviceStatus,jdbcType=VARCHAR}, #{devicePurchaseDate,jdbcType=TIMESTAMP}, ",
            "#{devicePurchasePrice}, #{deviceManufactureDate,jdbcType=TIMESTAMP}, ",
            "#{deviceServiceLife,jdbcType=TIMESTAMP}, #{deviceKeeperId,jdbcType=VARCHAR}, ",
            "#{note,jdbcType=VARCHAR})"
    })
    public void insert(Device device);


}
