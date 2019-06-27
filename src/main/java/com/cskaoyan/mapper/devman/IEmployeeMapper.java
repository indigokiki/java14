package com.cskaoyan.mapper.devman;

import com.cskaoyan.bean.devman.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface IEmployeeMapper {

    @Select("select emp_name from employee where emp_id=#{id}")
    public String findByid(Integer id);


    @Select("select * from employee")
    @Results({
            @Result(column="emp_id", property="empId", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="emp_name", property="empName", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
            @Result(column="id_code", property="idCode", jdbcType=JdbcType.VARCHAR),
            @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
            @Result(column="join_date", property="joinDate", jdbcType=JdbcType.DATE),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="education", property="education", jdbcType=JdbcType.VARCHAR),
            @Result(column="degree", property="degree", jdbcType=JdbcType.VARCHAR),
            @Result(column="major", property="major", jdbcType=JdbcType.VARCHAR),
            @Result(column="graduate_school", property="graduateSchool", jdbcType=JdbcType.VARCHAR),
            @Result(column="education_form", property="educationForm", jdbcType=JdbcType.VARCHAR),
            @Result(column="department_id", property="departmentId", jdbcType=JdbcType.VARCHAR)
    })
    public List<Employee> findAll();
}
