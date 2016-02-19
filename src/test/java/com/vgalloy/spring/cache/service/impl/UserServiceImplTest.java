package com.vgalloy.spring.cache.service.impl;

import com.vgalloy.spring.cache.Main;
import com.vgalloy.spring.cache.dao.UserDao;
import com.vgalloy.spring.cache.model.User;
import com.vgalloy.spring.cache.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 20/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class UserServiceImplTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    private User defaultUser;

    @Before
    public void init() {
        defaultUser = new User();
        defaultUser.setName("Name1");
        defaultUser = userService.save(defaultUser);
    }


    @Test
    public void testGetById() {
        User result = userService.getById(defaultUser.getId());
        userDao.removeAll();
        User result2 = userService.getById(defaultUser.getId());


        assertEquals(defaultUser, result);
        assertEquals(defaultUser, result2);
    }

    @Test
    public void testUpdate() {
        User getByIdResult = userService.getById(defaultUser.getId());
        defaultUser.setName("Name2");
        User updateResult = userService.update(defaultUser);
        User result2 = userService.getById(defaultUser.getId());
        User daoResult = userDao.getById(defaultUser.getId());

        assertNotEquals(defaultUser, getByIdResult);
        assertEquals(defaultUser, updateResult);
        assertEquals(defaultUser, result2);
        assertEquals(defaultUser, daoResult);
    }

    @Test
    public void testDeleteAll() {
        userService.removeAll();

        User serviceResult = userService.getById(defaultUser.getId());
        User daoResult = userDao.getById(defaultUser.getId());

        assertNull(serviceResult);
        assertNull(daoResult);
    }

    @Test
    public void testDeleteById() {
        userService.deleteById(defaultUser.getId());

        User serviceResult = userService.getById(defaultUser.getId());
        User daoResult = userDao.getById(defaultUser.getId());

        assertNull(serviceResult);
        assertNull(daoResult);
    }
}
