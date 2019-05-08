package com.jmh.hello_service.controller;

import com.jmh.hello_service.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @version [版本号, 2019/4/1]
 * @Classname HelloController
 * @Description TODO
 * @Date 2019/4/1
 * @Created by jiangmenghui
 */
@Slf4j
@RestController
@RequestMapping(value = "/helloController")
public class HelloController {
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value= "/hello", method= RequestMethod.GET)
    public String index() throws InterruptedException {
        List<String> serviceIds = client.getServices();
        StringBuilder buf = new StringBuilder();
        if (!CollectionUtils.isEmpty(serviceIds)) {
            for (String s : serviceIds) {
                System.out.println("serviceId:" + s);
                List<ServiceInstance> serviceInstances = client.getInstances(s);
                if (!CollectionUtils.isEmpty(serviceInstances)) {
                    for (ServiceInstance si : serviceInstances) {
                        buf.append("[" + si.getServiceId() + " host=" + si.getHost() + " port=" + si.getPort() + " uri=" + si.getUri() + "]");
                    }
                } else {
                    buf.append("no service.");
                }
            }
        }
        System.out.println(buf);
        return "Hello World";
    }

    @RequestMapping(value= "/hello1", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value= "/hello2", method= RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name,age);
    }
    @RequestMapping(value= "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        System.out.println("------------");
        return "Hello "+ user.getName() + ", " + user. getAge();
    }

}
