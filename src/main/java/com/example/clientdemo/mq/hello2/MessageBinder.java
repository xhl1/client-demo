package com.example.clientdemo.mq.hello2;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @ClassName: MessageBinder
 * @Package com.example.clientdemo.mq.hello2
 * @Description: 定义mq连接  需要在配置文件配置队列(目的地)
 * @Date 2018/5/31下午 6:56
 */
public interface MessageBinder {
    //生产者
    String TEST_HELLO_OUTPUT = "testHelloOuput";

    String TEST_OUTPUT = "testOutput";
    //消费者
    String TEST_HELLO_INPUT = "testHelloInput";

    @Output(TEST_HELLO_OUTPUT)
    MessageChannel messageOutput();

    @Output(TEST_OUTPUT)
    MessageChannel messageTest();

    @Input(TEST_HELLO_INPUT)
    MessageChannel messageInput();
}
