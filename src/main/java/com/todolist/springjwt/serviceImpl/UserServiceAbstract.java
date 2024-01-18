/**
 * @author Shreepad Kulkarni
 *
 * ${tags}
 */

// This Abstract UserServiceAbstract represents the methods to perform the CRUD by connecting the controller and Repository
// Abstraction is one of the four pillors of OOPS.
package com.todolist.springjwt.serviceImpl;

public abstract class UserServiceAbstract {
    public abstract void deleteById(Long id);
}