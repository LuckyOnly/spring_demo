import com.zff.service.IAccountService;
import org.junit.Test;

public class AccountTest {
    private IAccountService as;
    @Test
    public void testTransfer(){
        as.transfer("aa","bb",11f);
    }
}
