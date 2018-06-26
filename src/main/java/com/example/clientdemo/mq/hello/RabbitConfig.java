package com.example.clientdemo.mq.hello;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbitConfig
 * @Package com.example.clientdemo.mq
 * @Description: mq连接定义
 * @Date 2018/5/31下午 6:25
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue dateQueue() {
        return new Queue("date");
    }

    @Bean
    public Queue objQueue() {
        return new Queue("object");
    }

}
