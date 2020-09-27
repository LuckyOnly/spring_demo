package com.zff.service;

import com.zff.domain.Account;

/*
账号业务层接口
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();
    /**
     * 模拟更新账户
     */
    void updateAccount(int i);
    /**
     * 模拟删除账户
     */
    int deleteAccount();

    /**
     * 根据ID查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName,String targetName,Float money);
}
