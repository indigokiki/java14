package com.cskaoyan.mapper;

import com.cskaoyan.bean.Department;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

public interface DeparmenMapper {
    @Select("select * from department")
    @Results({
            @Result(id = true, property = "departmentId", column = "department_id"),
            @Result(property = "departmentName", column = "department_name"),
            @Result(property = "note", column = "note")
    })
    List<Department> findAll();

}
