package com.vgalloy.springtest.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vgalloy.springtest.jpa.entity.User;

/**
 * Created by Vincent Galloy on 21/03/16.
 */
public interface UserRepository extends CrudRepository <User, Long> {

	List<User> findAll();
}
