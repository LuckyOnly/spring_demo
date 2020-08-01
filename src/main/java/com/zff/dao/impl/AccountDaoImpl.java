package com.zff.dao.impl;

import com.zff.dao.AccountDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class AccountDaoImpl implements AccountDao {
    public void saveAccount() {
        System.out.println("save data");
    }
}
