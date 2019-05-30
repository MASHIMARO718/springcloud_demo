package com.jmh.hello_service.controller;

import com.jmh.hello_service.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version [版本号, 2019/4/1]
 * @Classname HelloController
 * @Description TODO
 * @Date 2019/4/1
 * @Created by jiangmenghui
 */
@Slf4j
@Controller
@RequestMapping(value = "/HtmlController")
public class HtmlController {
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value= "/hello2")
    public String index() throws InterruptedException {
        return "readingList";
    }


}
