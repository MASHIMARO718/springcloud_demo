package com.jmh.hello_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author by jiangmenghui
 * @version [版本号, 2019/5/16]
 * @Classname MyUserDetailsService
 * @Description TODO
 * @Date 2019/5/16
 */
@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("name:"+s);
        User user = new User(s,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
