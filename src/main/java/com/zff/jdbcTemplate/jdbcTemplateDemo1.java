package com.zff.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

public class jdbcTemplateDemo1 {
    public static void main(String[] args) {
        /*
        jdbc内置数据源
         */
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setDriverClassName("");
        ds.setUrl("");
        ds.setUsername("");
        ds.setPassword("");
        JdbcTemplate jt =new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money) values('ccc',1000f)");
    }
}
