package com.example.dao;

import java.util.List;

import com.example.models.User;

public interface UserDao {
	
	void createUser(User u);
	
	User readUserByUsername(String username);
	
	List<User> readAllUsers();
	
	void updateUser(User u);
	
	boolean deleteUser(User u);

}
