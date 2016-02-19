package com.vgalloy.spring.cache.service.impl;

import com.vgalloy.spring.cache.dao.UserDao;
import com.vgalloy.spring.cache.model.User;
import com.vgalloy.spring.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
@Service
@CacheConfig(cacheNames="User")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    @Cacheable
    public User getById(long id) {
        return dao.getById(id);
    }

    @Override
    public User save(User user) {
        return dao.save(user);
    }

    @Override
    @CachePut(key="#user.id")
    public User update(User user) {
        return dao.update(user);
    }

    @Override
    @CacheEvict
    public void deleteById(long id) {
        dao.deleteById(id);
    }

    @Override
    @CacheEvict(allEntries=true)
    public void removeAll() {
        dao.removeAll();
    }
}
