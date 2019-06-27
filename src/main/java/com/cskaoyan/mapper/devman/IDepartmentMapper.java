package com.cskaoyan.mapper.devman;

import com.cskaoyan.bean.devman.Department;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IDepartmentMapper {

    @Select("select * from department")
    @Results({
            @Result(column="department_id", property="departmentId", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="department_name", property="departmentName", jdbcType=JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    public List<Department> findAll();
}
