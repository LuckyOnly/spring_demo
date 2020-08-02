package com.zff.service;

import com.zff.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有账号信息
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账号信息
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存账号信息
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账号信息
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账号信息
     * @param id
     */
    void deleteAccount(Integer id);
}
