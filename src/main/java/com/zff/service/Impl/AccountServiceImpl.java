package com.zff.service.Impl;

import com.zff.dao.AccountDao;
import com.zff.domain.Account;
import com.zff.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void saveAccount() {

    }

    @Override
    public void updateAccount(int i) {

    }

    @Override
    public int deleteAccount() {
        return 0;
    }

    @Override
    public Account findAccountById(Integer id) {

        return accountDao.findAccountById(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account source=accountDao.findAccountByName(sourceName);
        Account target=accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(source.getMoney()+money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }
}
