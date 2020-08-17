package com.zff.service.impl;

import com.zff.dao.AccountDao;
import com.zff.dao.impl.AccountDaoImpl;
import com.zff.domain.Account;
import com.zff.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * 账号业务层实现类
 */
@Component
public class AccountServiceImpl implements AccountService {
//    @Autowired

    private AccountDao accountDao;
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private Account account;
    public List<Account> findAllAccount() {
        List<Account> accounts=null;
        try{
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            builder=new SqlSessionFactoryBuilder();
            factory=builder.build(in);
            session = factory.openSession();
            accountDao=session.getMapper(AccountDao.class);

           accounts= accountDao.findAllAccount();
            session.commit();
            session.close();
            in.close();
        }
        catch (Exception e){
            System.out.println(false);
        }
        return accounts;
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
