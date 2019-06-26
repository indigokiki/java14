package com.erp.mapper;

import com.erp.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUserById(@Param("id") int id);
}
