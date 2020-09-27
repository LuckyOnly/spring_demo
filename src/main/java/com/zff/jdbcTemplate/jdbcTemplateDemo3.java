package com.zff.jdbcTemplate;

import com.zff.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao=(AccountDao)ac.getBean("accountDao",AccountDao.class);
        accountDao.findAccountById(1);
    }
}
