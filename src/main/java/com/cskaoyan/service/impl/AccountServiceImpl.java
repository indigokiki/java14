package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Account;
import com.cskaoyan.mapper.AccountMapper;
import com.cskaoyan.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    AccountMapper accountMapper;
    @Override
    public void transcation(Integer a, Integer b) {
        Account account1 = accountMapper.findById(a);
        Double money1 = account1.getMoney();
        account1.setMoney(money1-100);

        Account account2 = accountMapper.findById(b);
        Double money2 = account2.getMoney();
        account2.setMoney(money2+100);

        accountMapper.update(account1);
        int i=1/0;
        accountMapper.update(account2);

    }
}
