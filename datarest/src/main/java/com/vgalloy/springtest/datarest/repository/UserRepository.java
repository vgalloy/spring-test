package com.vgalloy.springtest.datarest.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vgalloy.springtest.datarest.entity.User;

/**
 * Created by Vincent Galloy on 27/04/16.
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(@Param("name") String name);
}
