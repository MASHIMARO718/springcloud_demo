package com.jmh.feignconsumer.service;

import com.jmh.feignconsumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @version [版本号, 2019/4/3]
 * @Classname HelloService
 * @Description TODO
 * @Date 2019/4/3
 * @Created by jiangmenghui
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/helloController/hello")
    String hello();

    @RequestMapping(value= "/helloController/hello1", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name) ;
    @RequestMapping(value= "/helloController/hello2", method= RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
    @RequestMapping(value = "/helloController/hello3", method= RequestMethod.POST)
    String hello(@RequestBody User user);
}
