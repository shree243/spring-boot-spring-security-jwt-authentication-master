/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */
package com.springboot.springjwt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.todolist.springjwt.SpringBootSecurityJwtApplication;
import com.todolist.springjwt.models.Todo;
import com.todolist.springjwt.repository.TodoRepo;
import com.todolist.springjwt.serviceImpl.TodoService;

@ContextConfiguration(classes = SpringBootSecurityJwtApplication.class)
@SpringBootTest
public class TodoTest {

	@Autowired
	private TodoRepo todorepo;

	@Autowired
	private TodoService todoService;

// test case to findAllTodo from Database, this test case are written based in service level
	
	@Test
	public void findAllTodo() {

		List<Todo> list = todoService.getAllTodos();
		assertNotNull(list);
		System.out.println(list);
	}


	// test case to saveTodo in Database, this test case are written based in service level
		
	@Test
	public void saveTodo() {
		Todo todo = new Todo();
		todo.setCompleted(false);
		todo.setDate("03-01-2000");
		todo.setDescription("description");
		todo.setId(9);
		todo.setImportant(true);
		todo.setTag("tag");
		todo.setTitle("title");
		todo.setUserid(5);
		Todo savedtodo = todorepo.save(todo);
		assertNotNull(savedtodo);
		System.out.println(savedtodo);
	}
}
 