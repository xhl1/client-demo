package com.example.clientdemo.mq.hello;

import com.example.clientdemo.entity.Account;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: HelloSender
 * @Package com.example.clientdemo.mq
 * @Description: 生产者
 * @Date 2018/5/31下午 6:27
 */
@Component
public class HelloSender {
    @Autowired
    private Queue dateQueue;
    @Autowired
    private Queue objQueue;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "now date ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend(dateQueue.getName(), context);
    }

    public void sendObj(Account account) {
        System.out.println("Sender : " + account);
        rabbitTemplate.convertAndSend(objQueue.getName(), account);
    }

}
