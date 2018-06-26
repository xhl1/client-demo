package com.example.clientdemo.mq.hello;

import com.example.clientdemo.entity.Account;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HelloReceiver
 * @Package com.example.clientdemo.mq
 * @Description: 消费者
 * @Date 2018/5/31下午 6:32
 */
@Component
public class HelloReceiver {
    @RabbitListener(queues = "date")
    public void processDate(String date) {
        System.out.println("Receiver ==================: " + date);
    }

    @RabbitListener(queues = "object")
    public void processObj(Account account) {
        System.out.println("Receiver ==================: " + account);
        System.out.println("Receiver ==================: " + account.getUserName());
        System.out.println("Receiver ==================: " + account.getPassword());
    }


}
