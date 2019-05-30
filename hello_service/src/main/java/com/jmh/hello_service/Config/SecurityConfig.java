package com.jmh.hello_service.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author by jiangmenghui
 * @version [版本号, 2019/5/16]
 * @Classname BrowerSecurityConfig
 * @Description TODO
 * @Date 2019/5/16
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").
                access("hasRole('admin')").antMatchers("/**").permitAll()
                .and().formLogin().loginPage("/login").failureUrl("/login?error=true");
    }
    @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
                User user = new User(username, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admsin"));
                return user;
            };
        });
    }
}

