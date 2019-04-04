package com.jmh.rabbitmqhello.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by jiangmenghui
 * @version [版本号, 2019/4/4]
 * @Classname RabbitConfig
 * @Description TODO
 * @Date 2019/4/4
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue(){
            return new Queue("hello");
    }
}
