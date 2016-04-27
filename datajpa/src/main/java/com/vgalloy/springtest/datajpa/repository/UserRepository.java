package com.vgalloy.springtest.datajpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vgalloy.springtest.datajpa.entity.User;

/**
 * Created by Vincent Galloy on 21/03/16.
 */
public interface UserRepository extends CrudRepository <User, Long> {

	List<User> findAll();
}
