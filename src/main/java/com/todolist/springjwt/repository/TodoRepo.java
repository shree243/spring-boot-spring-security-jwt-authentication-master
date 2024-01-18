/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */

// This Interface Represents the JPA repository of Todo repository to perform the CRUD operation with Database

package com.todolist.springjwt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.springjwt.models.Todo;


@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer>{

	
	 List<Todo> findByUserid(int userId);

}

