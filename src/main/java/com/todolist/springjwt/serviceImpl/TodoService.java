/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */
// This todoservice represents the methods to perform the CRUD by connecting the controller and Repository

package com.todolist.springjwt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.springjwt.models.Todo;
import com.todolist.springjwt.repository.TodoRepo;

//Inheritence - one of the main pillors of OOPS 
@Service
public class TodoService extends TodoServiceBase {

	@Autowired
	public TodoRepo todoRepo;

	// polymorphism - which is one of the four pillors of OOPS.
	
	public List<Todo> getAllTodos() {
		return todoRepo.findAll();
	}

	public List<Todo> getByUserId(int id) {
		return todoRepo.findByUserid(id);
	}

	public Todo getById(int id) {
		return todoRepo.findById(id).orElse(null);
	}

	public Todo Save(Todo todo) {
		return todoRepo.save(todo);
	}

}
