package com.estesting.gateway.repository;

import com.estesting.gateway.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {

}
