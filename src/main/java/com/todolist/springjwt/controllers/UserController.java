/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */
package com.todolist.springjwt.controllers;

import java.util.List;
import com.todolist.springjwt.serviceImpl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.springjwt.models.User;
import com.todolist.springjwt.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

//	 User Controller to perform the CRUD operation with Database
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	private UserServiceAbstract userServicesAbstract;

//	Http request for delete of User and update in Database
	
	@PostMapping("/delete")
	public void deleteUser(@RequestParam("id") Long id) {
		try {
			userServicesAbstract.deleteById(id);
			System.out.println("User with ID " + id + " has been deleted");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	Http request for findAllUsers of User from Database
	
	@GetMapping("/findAllUsers")
	public List<User> findAllUsers() {
		List<User> users = null;
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return users;
	}


//	Http request for findUserById of User from Database
	
	@PostMapping("/findUserById")
	public User findAllUsers(long userId) {
		User users = null;
		try {
			users = userRepository.findById(userId).orElse(null);
		} catch (Exception e) {
			System.out.println(e);
		}
		return users;
	}

}
