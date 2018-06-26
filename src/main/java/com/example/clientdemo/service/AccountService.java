package com.example.clientdemo.service;

import com.example.clientdemo.dao.AccountDao;
import com.example.clientdemo.entity.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AccountService
 * @Package com.example.clientdemo.service
 * @Description:
 * @Date 2018/5/31下午 2:10
 */
@Service
public class AccountService {
    private Logger logger = Logger.getLogger(AccountService.class);
    @Autowired
    private AccountDao accountDao;

    public List<Account> accountList() {
        List<Account> accounts = accountDao.selectAll();
        for (Account account : accounts) {
            logger.info("service:"+account+"!!!!");
        }
        return accounts;
    }

    public void insertion(Account account){
        logger.info("Service:"+account);
        long time = System.currentTimeMillis();
        account.setCreateTime(time);
        account.setUpdateTime(time);
        accountDao.insert(account);
    }


    public Boolean queryBoolean(Integer s) {

        return true;
    }

    public Account findUserName(String userName){
        Account userName1 = accountDao.findUserName(userName);
        accountDao.sqrt(1);
        return userName1;
    }

}
