package com.zff.service.impl;

import com.zff.dao.AccountDao;
import com.zff.dao.impl.AccountDaoImpl;
import com.zff.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
//    private String name;

//    public void setName(String name) {
//        this.name = name;
//    }

//    AccountDao accountDao = new AccountDaoImpl();
    //自动按照类型注入：只有容器中唯一的一个bean对象类型AccountDao和要注入的变量类型accountDao匹配
    // 如果有多个，以变量名称去找类
//    @Autowired
//    @Qualifier(value="accountDaoImpl")//不能独立使用，要跟Autowired配合
//    private AccountDao accountDao=null;

    @Resource(name="accountDaoImpl")//可以独立使用
    private AccountDao accountDao=null;
    public void saveAccount() {
        accountDao.saveAccount();
//        System.out.println(name);
    }
}
