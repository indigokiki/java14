package com.cskaoyan.mapper;

import com.cskaoyan.bean.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {

    @Update("update t_account set name=#{name},money=#{money} where id=#{id}")
    void update(Account account);

    @Select("select * from t_account where id=#{id}")
    Account findById(Integer id);
}
