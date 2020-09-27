package com.zff.dao.impl;

import com.zff.dao.AccountDao;
import com.zff.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao2")
public class AccountDaoImpl2  implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer id) {
        List<Account> account=jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),100);

        return account.isEmpty()?null:account.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> account=jdbcTemplate.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),"eee");
        if(account.isEmpty()){
            return null;
        }
        if(account.size()>1){
            throw new RuntimeException("结果不唯一");
        }
        return account.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
