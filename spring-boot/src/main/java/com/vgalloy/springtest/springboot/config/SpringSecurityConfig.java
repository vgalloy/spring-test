package com.vgalloy.springtest.springboot.config;

import com.vgalloy.springtest.springboot.service.impl.SecurityServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 30/01/17.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .userDetailsService(new SecurityServiceImpl())
            .exceptionHandling()
            .and()
                .authorizeRequests()
                .antMatchers("/home").authenticated();
    }
}
