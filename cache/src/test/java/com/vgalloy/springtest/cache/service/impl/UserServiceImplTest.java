package com.vgalloy.springtest.cache.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import com.vgalloy.springtest.cache.Main;
import com.vgalloy.springtest.cache.dao.UserDao;
import com.vgalloy.springtest.cache.model.User;
import com.vgalloy.springtest.cache.service.UserService;

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
    public void testGetAll() {
        userService.getAll();
        userDao.removeAll();

        List<User> userList = userService.getAll();

        assertEquals(userList.size(), 1);
        assertEquals(userList.get(0), defaultUser);
    }

    @Test
    public void testSaveNotAttach() {
        defaultUser.setName("Name2");
        User result = userService.getById(defaultUser.getId());
        assertNotEquals(defaultUser, result);
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
        defaultUser.setName("Name2");
        User updateResult = userService.update(defaultUser);
        User result2 = userService.getById(defaultUser.getId());
        User daoResult = userDao.getById(defaultUser.getId());

        assertEquals(defaultUser, updateResult);
        assertEquals(defaultUser, result2);
        assertEquals(defaultUser, daoResult);
    }

    @Test
    public void testUpdateNotAttach() {
        defaultUser.setName("Name2");
        User result = userService.update(defaultUser);
        result.setName("Name3");
        User result2 = userService.getById(defaultUser.getId());

        assertNotEquals(result, defaultUser);
        assertNotEquals(result, result2);
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
