package com.cskaoyan.mapper.devman;

import com.cskaoyan.bean.devman.DeviceFault;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IDeviceFaultMapper {

    @Select("select * from device_fault")
    @Results(value = {
            @Result(column="device_fault_id", property="deviceFaultId", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_id", property="deviceName",javaType = String.class,
                    one = @One(select = "com.cskaoyan.mapper.devman.IDeviceMapper.findNameById")),
            @Result(column="device_fault_cause", property="deviceFaultCause", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_fault_detail", property="deviceFaultDetail", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_fault_date", property="deviceFaultDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_fault_maintenance", property="deviceFaultMaintenance", jdbcType=JdbcType.VARCHAR)
    })
    public List<DeviceFault> findAll();
}
