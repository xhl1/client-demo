package com.example.clientdemo.mq.hello2;

import com.alibaba.fastjson.JSONObject;
import com.example.clientdemo.entity.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MessageSender
 * @Package com.example.clientdemo.mq.hello2
 * @Description:
 * @Date 2018/5/31下午 7:02
 */
@EnableBinding(MessageBinder.class)
public class MessageSender {
    private Logger logger = Logger.getLogger(MessageSender.class);
    @Autowired
    @Output(MessageBinder.TEST_HELLO_OUTPUT)
    private MessageChannel messageOutput;

    @Autowired
    @Output(MessageBinder.TEST_OUTPUT)
    private MessageChannel messageChannel;

    public void sendMq(Account account) {
        String context = "now account ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
        logger.info("发送时间 : " + context);
        messageOutput.send(MessageBuilder.withPayload(JSONObject.toJSONString(account)).build());
    }

    public void sendMq(Integer message){
        String context="now message".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
        logger.info("发送成功时间:"+context);
        messageChannel.send(MessageBuilder.withPayload(message).build());
    }
}