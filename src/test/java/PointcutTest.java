import com.zff.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointcutTest {
    public static void main(String[] args) {
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService=(IAccountService) ac.getBean("accountService");
        accountService.saveAccount();
        accountService.updateAccount(1);
        accountService.deleteAccount();
    }
}
