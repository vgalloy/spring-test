package com.vgalloy.springtest.cache;


import net.sf.ehcache.config.CacheConfiguration;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.vgalloy.springtest.cache.dao.UserDao;
import com.vgalloy.springtest.cache.model.User;
import com.vgalloy.springtest.cache.service.UserService;

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

        // Init
        UserService userService = applicationContext.getBean(UserService.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);

        // Set the user
        User user = new User();
        user.setName("Name1");

        // User case
        System.out.println("Save user with service ...");
        user = userService.save(user);

        System.out.println("Get user with service ...");
        System.out.println(userService.getById(user.getId()));

        System.out.println("Update user with dao ...");
        User user2 = new User(user.getId(), "new name"); // Objects stay attach so we have to create a new one to test update
        userDao.update(user2);

        System.out.println("Get user with service ...");
        System.out.println(userService.getById(user.getId()));

        System.out.println("Get user with dao ...");
        System.out.println("dao :" + userDao.getById(user.getId()));
    }

//    @Bean
//    public CacheManager cacheManager() {
//        CacheConfiguration cacheConfiguration = new CacheConfiguration();
//        cacheConfiguration.setName(UserService.CACHE_NAME);
//        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
//        cacheConfiguration.setMaxEntriesLocalHeap(1000);
//
//        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
//        config.addCache(cacheConfiguration);
//
//        return new EhCacheCacheManager(net.sf.ehcache.CacheManager.newInstance(config));
//    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache(UserService.CACHE_NAME)));
        return cacheManager;
    }
}
