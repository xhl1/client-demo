package com.example.clientdemo.mq.hello2;

import com.alibaba.fastjson.JSONObject;
import com.example.clientdemo.entity.Account;
import com.example.clientdemo.service.AccountService;
import com.example.clientdemo.feign.AgreementServiceClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MqMessageConsumer
 * @Package com.example.clientdemo.mq.hello2
 * @Description:
 * @Date 2018/6/1上午 10:19
 */
@EnableBinding(MessageBinder.class)
public class MqMessageConsumer {
    private Logger logger = Logger.getLogger(MqMessageConsumer.class);
    @Autowired
    private AccountService accountService;
    @Autowired
    private AgreementServiceClient agreementServiceClient;

   @StreamListener(MessageBinder.TEST_HELLO_INPUT)
    public void receive(Message<String> message) {
        String context = "now receive ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
        logger.info("接收时间:" + context);
        logger.info("接收数据:" + message);

        try {
            String payload = message.getPayload();
            logger.info("消息内容:" + payload);
            Account account = JSONObject.parseObject(payload, Account.class);
            account.setMobile("111111111111");
            account.setRelatedId("2");
            account.setStatus(1);
            account.setType(1);
            accountService.insertion(account);
        } catch (Exception e) {
            logger.info("接收消息异常处理:" + e);
            throw new RuntimeException(e);
        }
    }

    @StreamListener(MessageBinder.TEST_HELLO_INPUT)
    public void receive2(Message<Long> message){
        Long payload = message.getPayload();
        logger.info("消息内容为:"+payload);
        agreementServiceClient.mqConsume(payload);
    }
}
