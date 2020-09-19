package com.zff.jdbcTemplate;

import com.zff.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class jdbcTemplateDemo2 {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt=(JdbcTemplate)ac.getBean("dataTemplate",JdbcTemplate.class);
        jt.execute("insert into account(name,money) values('ccc',1000f)");
        //保存
        jt.update("insert into account(name,money) values(?,?)","eee","222");
        //更新
        jt.update("update account set name=?,money=? where id=?","eew","333",7);
        //删除
        jt.update("delete from account where id=?",8);
        //查询所有
        List<Account> as =new ArrayList<Account>();

//        as=jt.query("select * from account where name=?",new AccountRowMapper(),"eee");
        as=jt.query("select * from account where money>?",new BeanPropertyRowMapper<Account>(Account.class),100f);
        for(Account a:as){

            System.out.println(a.toString());
        }
        //查询一个
        List<Account> as1 =new ArrayList<Account>();
        as1=jt.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),100);
        System.out.println(as1.isEmpty()?"no data":as1.get(0));
        //查询返回一行一列(聚合函数，不能用group by)
        jt.queryForObject("select count* from account where money>?",Integer.class,100f);
    }

}
class AccountRowMapper implements RowMapper<Account>{

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account at= new Account();
        at.setId(resultSet.getInt("id"));
        at.setName(resultSet.getString("name"));
        at.setMoney(resultSet.getFloat("money"));
        return at;
    }
}
