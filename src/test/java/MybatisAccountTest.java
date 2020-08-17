import com.zff.dao.AccountDao;
import com.zff.domain.Account;
import com.zff.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.List;

public class MybatisAccountTest {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;
    private Account account;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder=new SqlSessionFactoryBuilder();
        factory=builder.build(in);
        session = factory.openSession();
        accountDao=session.getMapper(AccountDao.class);
    }

    @After
    public void close() throws Exception{
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAllAccount(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        //Component 注解默认取类名且首字母小写
        AccountService as3 = (AccountService)ac.getBean("accountServiceImpl");
        System.out.println(as3.findAllAccount());

//        List<Account> accountList= accountDao.findAllAccount();
//        for(Account account:accountList){
//            System.out.println(account);
//        }

    }


}
