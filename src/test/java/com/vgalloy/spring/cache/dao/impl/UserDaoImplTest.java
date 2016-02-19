package com.vgalloy.spring.cache.dao.impl;

import com.vgalloy.spring.cache.Main;
import com.vgalloy.spring.cache.dao.UserDao;
import com.vgalloy.spring.cache.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;
    private User defaultUser;

    @Before
    public void init() {
        userDao.removeAll();
        defaultUser = new User();
        defaultUser.setName("Default Name");
        defaultUser = userDao.save(defaultUser);
    }

    @Test
    public void testGetAll() {
        assertEquals(userDao.getAll().size(), 1);
        assertEquals(userDao.getAll().get(0), defaultUser);
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setName("Name 1");

        user = userDao.save(user);

        assertEquals(user.getId(), 2);
        assertEquals(userDao.getAll().size(), 2);
        assertEquals(userDao.getById(2), user);
    }

    @Test
    public void testUpdate() {
        User user = defaultUser.clone();
        defaultUser.setName("Name 2");
        assertEquals(user, userDao.getById(defaultUser.getId()));

        User result = userDao.update(defaultUser);

        assertEquals(result, defaultUser);
        assertEquals(userDao.getAll().size(), 1);
        assertEquals(userDao.getAll().get(0), defaultUser);
    }

    @Test
    public void testDelete() {
        userDao.removeAll();
        assertEquals(userDao.getAll(), new ArrayList<User>());
    }
}