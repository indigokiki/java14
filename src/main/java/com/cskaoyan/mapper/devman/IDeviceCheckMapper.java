package com.cskaoyan.mapper.devman;

import com.cskaoyan.bean.devman.DeviceCheck;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IDeviceCheckMapper {

    @Select("select * from device_check")
    @Results({
            @Result(column="device_check_id", property="deviceCheckId", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_id", property="deviceName",javaType = String.class,
            one = @One(select = "com.cskaoyan.mapper.devman.IDeviceMapper.findNameById")),
            @Result(column="device_check_emp_id", property="deviceCheckEmpId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_check_emp_id", property="deviceCheckEmp", javaType = String.class,
            one = @One(select = "com.cskaoyan.mapper.devman.IEmployeeMapper.findByid")),
            @Result(column="device_check_date", property="deviceCheckDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_check_result", property="deviceCheckResult", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_check_fault_id", property="deviceCheckFaultId", jdbcType=JdbcType.VARCHAR)
    })
    public List<DeviceCheck> findAll();
}
