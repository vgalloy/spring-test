package com.vgalloy.springtest.cache.dao;

import java.util.List;

import com.vgalloy.springtest.cache.model.User;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 19/02/16.
 */
public interface UserDao {

	List<User> getAll();

	User getById(long id);

	User save(User user);

	User update(User user);

	void deleteById(long id);

	void removeAll();
}
