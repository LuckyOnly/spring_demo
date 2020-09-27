package com.zff.ui;

import com.zff.service.IAccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }
}
