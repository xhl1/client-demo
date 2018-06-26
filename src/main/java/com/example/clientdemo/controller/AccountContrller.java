package com.example.clientdemo.controller;

import com.example.clientdemo.entity.Account;
import com.example.clientdemo.feign.AgreementServiceClient;
import com.example.clientdemo.mq.hello2.MessageSender;
import com.example.clientdemo.service.AccountService;
import com.example.clientdemo2.entity.Agreement;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: AccountContrller
 * @Package com.example.clientdemo.controller
 * @Description:
 * @Date 2018/5/31下午 2:13
 */
@RestController
public class AccountContrller {
    private Logger logger = Logger.getLogger(AccountContrller.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private AgreementServiceClient agreementServiceClient;

    @GetMapping("/list")
    public List<Account> accountList() {
        List<Account> accounts = accountService.accountList();
        for (Account account : accounts) {
            logger.info("账户信息为:" + account + "----");
        }
        return accounts;
    }

   // @Scheduled(cron = "0 */1 * * * ?")//每隔1分钟执行一次
    @GetMapping("/set")
    public void send() {
        Account account = new Account();
        account.setUserName("测试者12345");
        account.setPassword("123456");
        messageSender.sendMq(account);
    }

   // @Scheduled(fixedRate = 5000)  //每5秒执行一次
    @GetMapping("/setId")
    public String send2() {
        agreementServiceClient.mqConsume(1L);
        return "成功!";
    }

    @PostMapping("/feign")
    public Agreement send4() {
        Agreement agreement=new Agreement();
        agreement.setId(0l);
        agreement = agreementServiceClient.findAgreement(agreement);
        if (agreement==null) {
            logger.info("服务调用错误!");
        }
        return agreement;
    }

    @GetMapping("/set2")
    public String send3() {
        messageSender.sendMq(1);
        return "成功!";
    }

    @PostMapping("/create")
    public String create(@RequestBody Account account) {
        System.out.println(account);
        return "成功!";
    }

    @GetMapping("/boolean")
    public Boolean queryBoolean(Integer s) {
        Boolean aBoolean = accountService.queryBoolean(s);
        return aBoolean;
    }

    @PostMapping("/findUserName")
    public Account findUserName(@RequestBody Account account) {
        Account userName = accountService.findUserName(account.getUserName());
        return userName;
    }
}
