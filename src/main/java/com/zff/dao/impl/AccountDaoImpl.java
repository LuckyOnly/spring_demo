package com.zff.dao.impl;

import com.zff.dao.AccountDao;
import com.zff.domain.Account;

import java.util.List;

/**
 * 账号持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    private  AccountDao accountDao;
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        account.setId(53);
        account.setUid(1111);
        account.setMoney(768.2);
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        account.setId(53);
        account.setUid(1222);
        account.setMoney(68.2);
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
