/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */

// This Interface Represents the JPA repository of User repository to perform the CRUD operation with Database


package com.todolist.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.springjwt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
