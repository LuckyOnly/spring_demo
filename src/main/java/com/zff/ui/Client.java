package com.zff.ui;

import com.zff.dao.AccountDao;
import com.zff.dao.impl.AccountDaoImpl;
import com.zff.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
//        获取容器
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");

        //Component 注解默认取类名且首字母小写
        AccountService as3 = (AccountService)ac.getBean("accountServiceImpl");
        as3.saveAccount();
        /**        AccountService as = (AccountService)ac.getBean("accountService");
        AccountDao adao = ac.getBean("accountDao",AccountDao.class);
        System.out.println(as);
        System.out.println(adao);
        as.saveAccount();
         */
    }
}
