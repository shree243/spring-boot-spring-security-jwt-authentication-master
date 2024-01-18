/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */


// This UserService represents the methods to perform the CRUD by connecting the controller and Repository

package com.todolist.springjwt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todolist.springjwt.repository.UserRepository;

@Service
public class UserService extends UserServiceAbstract {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}