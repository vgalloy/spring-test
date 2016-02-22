package com.vgalloy.spring.cache.service;

import com.vgalloy.spring.cache.model.User;

import java.util.List;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
public interface UserService {

    String CACHE_NAME = "User";

    List<User> getAll();

    User getById(long id);

    User save(User user);

    User update(User user);

    void deleteById(long id);

    void removeAll();
}
