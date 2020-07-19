package com.zff.service.impl;

import com.zff.dao.AccountDao;
import com.zff.dao.impl.AccountDaoImpl;
import com.zff.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(name);
    }
}
