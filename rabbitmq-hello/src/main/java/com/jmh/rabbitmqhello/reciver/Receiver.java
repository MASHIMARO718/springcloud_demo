package com.jmh.rabbitmqhello.reciver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author by jiangmenghui
 * @version [版本号, 2019/4/4]
 * @Classname Receiver
 * @Description TODO
 * @Date 2019/4/4
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }
}
