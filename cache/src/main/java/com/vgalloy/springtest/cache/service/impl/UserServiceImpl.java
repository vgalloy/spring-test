package com.vgalloy.springtest.cache.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vgalloy.springtest.cache.dao.UserDao;
import com.vgalloy.springtest.cache.model.User;
import com.vgalloy.springtest.cache.service.UserService;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
@Service
@CacheConfig(cacheNames=UserService.CACHE_NAME)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    @Cacheable
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    @Cacheable
    public User getById(long id) {
        return dao.getById(id);
    }

    @Override
    @CachePut(key="#user.id")
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
