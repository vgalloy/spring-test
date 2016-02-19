package com.vgalloy.spring.cache;

import com.vgalloy.spring.cache.dao.UserDao;
import com.vgalloy.spring.cache.model.User;
import com.vgalloy.spring.cache.service.UserService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
@EnableCaching
@Component
@ComponentScan
@Configuration
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        // INIT
        UserService userService = applicationContext.getBean(UserService.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);

        // USER
        User user = new User();
        user.setName("Name1");

        System.out.println("Save user with service ...");
        user = userService.save(user);

        System.out.println("Get user with service ...");
        System.out.println(userService.getById(user.getId()));

        System.out.println("Update user with dao ...");
        user.setName("Name2");
        userDao.update(user);

        System.out.println("Get user with service ...");
        System.out.println(userService.getById(1));

        System.out.println("Get user with dao ...");
        System.out.println("dao :" + userDao.getById(1));
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("User")));
        return cacheManager;
    }
}
