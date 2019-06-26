package com.erp.service;

import com.erp.bean.User;
import com.erp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        return user;
    }
}
