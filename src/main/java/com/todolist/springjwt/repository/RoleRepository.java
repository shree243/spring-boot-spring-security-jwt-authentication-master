/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */

// This Interface Represents the JPA repository of Role repository to perform the CRUD operation with Database

package com.todolist.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.springjwt.models.ERole;
import com.todolist.springjwt.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
