package com.vgalloy.spring.cache.dao.impl;

import com.vgalloy.spring.cache.dao.UserDao;
import com.vgalloy.spring.cache.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User save(User user) {
        long newIndex = 1;
        for (User userTmp : userList) {
            if(userTmp.getId() >= newIndex) {
                newIndex = userTmp.getId() + 1;
            }
        }
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
