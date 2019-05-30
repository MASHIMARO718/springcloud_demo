package com.jmh.feignconsumer.controller;

import com.jmh.feignconsumer.entity.User;
import com.jmh.feignconsumer.service.HelloService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by jiangmenghui
 * @version [版本号, 2019/4/3]
 * @Classname ConsumerController
 * @Description TODO
 * @Date 2019/4/3
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;
    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        //sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("123", 456)).append("\n");
        sb.append(helloService.hello(new User("gfd", 123))).append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isBlank(null));
    }
}
