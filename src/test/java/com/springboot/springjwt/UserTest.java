/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */
package com.springboot.springjwt;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.todolist.springjwt.SpringBootSecurityJwtApplication;
import com.todolist.springjwt.models.User;
import com.todolist.springjwt.repository.UserRepository;

@ContextConfiguration(classes = SpringBootSecurityJwtApplication.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserRepository userRepo;

	//test case to findAllusers from Database
	@Test
	public void findAllUser() {

		List<User> users = null;
		try {
			users = userRepo.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		assertNotNull(users);
		System.out.println(users);
	}

	@Test
	public void findByIdUser() {

		User users = null;
		try {
			long userId = 3;
			users = userRepo.findById(userId).orElse(null);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertNotNull(users);
		System.out.println(users);
	}
	
	//test case to delete user from Database
	@Test
	public void deleteUser() {

		User users = null;
		long id =9;
		try {
			userRepo.deleteById(id);
			System.out.println("User with ID " + id + " has been deleted");
		} catch (Exception e) {
			System.out.println(e);
		}
		assertNull(users);
		System.out.println(users);
	}
	
}
