/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */
package com.todolist.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.springjwt.models.Todo;
import com.todolist.springjwt.payload.request.TodoRequest;
import com.todolist.springjwt.repository.TodoRepo;
import com.todolist.springjwt.serviceImpl.TodoService;
import com.todolist.springjwt.serviceImpl.TodoServiceBase;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/todo")
public class TodoController {

	
//	 Todo Controller to perform the CRUD operation with Database
	
	@Autowired
	private TodoRepo todoRepo;

	@Autowired
	com.todolist.springjwt.serviceImpl.TodoService todoService;

//	Http request for creation of Todo and save in Database
	
	@PostMapping("/saveTodo")
	public ResponseEntity<Todo> createTodo(@RequestBody TodoRequest todo) {
//		 Used Try and catch to hadle Exception.
		try {
			Todo newTodo = new Todo();
			newTodo.setUserid(Integer.parseInt(todo.getUserId()));
			newTodo.setTitle(todo.getTitle());
			newTodo.setDescription(todo.getDescription());
			newTodo.setDate(todo.getDate());
			newTodo.setImportant(todo.isImportant());
			newTodo.setCompleted(todo.isCompleted());
			newTodo.setTag(todo.getTag());
			newTodo = todoService.Save(newTodo); 
// Todo has been saved 
			return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	This Api helps to Get all Todo's from Database
	
	@GetMapping("/getAllTodos")
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

//	This Http request to delete the todo acccording to todo id which has been saved in Database
	
	@GetMapping("/todos/delete/{id}")
	public ResponseEntity<String> deleteTodoById(@PathVariable Integer id) {
		try {
//			 Used Try and catch to hadle Exception.
			TodoServiceBase todoServices = new TodoService();
			todoService.deleteTodoById(id);
			return ResponseEntity.ok("Todo with ID " + id + " has been deleted");
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Todo");
		}
	}

//	This http request to fetch the todo accoring to particular used Id
	
	@GetMapping("/todos/{userId}")
	public List<Todo> getTodosByUserId(@PathVariable String userId) {
		return todoService.getTodosByUserId(Integer.parseInt(userId));
	}

//	 This http request helps us to fetch the particular todo by Id which has been saved in Database
	
	@GetMapping("/getById/todos/{id}")
	public Optional<Todo> getTodosById(@PathVariable String id) {
		Optional<Todo> Todo = todoService.getTodosById(Integer.parseInt(id));
		return Todo;
	}

	@PostMapping("/updateTodo")
	public ResponseEntity<Todo> updateTodo(
			@RequestBody com.todolist.springjwt.payload.request.TodoUpdateRequest todoUpdateRequest) {
		try {

			Optional<Todo> todo = todoRepo.findById(Integer.parseInt(todoUpdateRequest.getId()));

			Todo todoObj = todo.orElse(new Todo());

			todoObj.setCompleted(todoUpdateRequest.isCompleted());
			todoObj.setDate(todoUpdateRequest.getDate());
			todoObj.setDescription(todoUpdateRequest.getDescription());
			todoObj.setId(Integer.parseInt(todoUpdateRequest.getId()));
			todoObj.setImportant(todoUpdateRequest.isImportant());
			todoObj.setTag(todoUpdateRequest.getTag());
			todoObj.setTitle(todoUpdateRequest.getTitle());
			todoObj.setUserid(Integer.parseInt(todoUpdateRequest.getUserId()));
			Todo renewTodo = todoService.Save(todoObj);
			return new ResponseEntity<>(renewTodo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
