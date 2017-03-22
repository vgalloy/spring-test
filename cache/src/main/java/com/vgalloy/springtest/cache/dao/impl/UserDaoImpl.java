package com.vgalloy.springtest.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vgalloy.springtest.cache.dao.UserDao;
import com.vgalloy.springtest.cache.model.User;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private List<User> userList = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User getById(long id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User save(User user) {
        long newIndex = userList.stream()
                .map(User::getId)
                .max(Long::compareTo)
                .map(e -> e + 1)
                .orElse(1L);

        user.setId(newIndex);
        userList.add(user.clone());
        return user;
    }

    @Override
    public User update(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == user.getId()) {
                userList.set(i, user);
            }
        }
        return user;
    }

    @Override
    public void deleteById(long id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.remove(i);
            }
        }
    }

    @Override
    public void removeAll() {
        userList = new ArrayList<>();
    }
}
