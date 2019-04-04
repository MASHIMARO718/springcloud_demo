package com.jmh.gateway;

import com.jmh.gateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
