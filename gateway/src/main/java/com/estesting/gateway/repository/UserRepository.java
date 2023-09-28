package com.estesting.gateway.repository;

import com.estesting.gateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {
  List<User> findByUsername(String username);

  List<User> findByEmail(String email);
}
