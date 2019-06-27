package com.cskaoyan.mapper.devman;

import com.cskaoyan.bean.devman.DeviceCheck;
import com.cskaoyan.bean.devman.DeviceMaintain;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IDeviceMaintainMapper {

    @Select("select * from device_maintain")
    @Results({
            @Result(column="device_maintain_id", property="deviceMaintainId", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="device_fault_id", property="deviceFaultId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_maintain_emp_id", property="deviceMaintainEmpId", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_maintain_emp_id", property="deviceMaintainEmp",javaType = String.class,
                    one = @One(select = "com.cskaoyan.mapper.devman.IEmployeeMapper.findByid")),
            @Result(column="device_maintain_date", property="deviceMaintainDate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="device_maintain_result", property="deviceMaintainResult", jdbcType=JdbcType.VARCHAR),
            @Result(column="device_maintain_cost", property="deviceMaintainCost", jdbcType=JdbcType.DECIMAL),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    public List<DeviceMaintain> findAll();
}
