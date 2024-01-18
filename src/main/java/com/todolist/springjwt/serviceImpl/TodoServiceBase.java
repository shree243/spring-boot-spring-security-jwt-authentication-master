/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */

// This TodoServiceBase represents the methods to perform the CRUD by connecting the controller and Repository

package com.todolist.springjwt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.springjwt.models.Todo;
import com.todolist.springjwt.repository.TodoRepo;

@Service
public class TodoServiceBase {

	@Autowired
	public TodoRepo todoRepo;
	
	public void deleteTodoById(Integer id) {
		todoRepo.deleteById(id);
	}

	public Optional<Todo> getTodosById(Integer id) {
		return todoRepo.findById(id);
	}
	
	public List<Todo> getTodosByUserId(Integer userId) {
		return todoRepo.findByUserid(userId);
	}
}
