package com.zff.dao.impl;

import com.zff.dao.AccountDao;
import com.zff.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
