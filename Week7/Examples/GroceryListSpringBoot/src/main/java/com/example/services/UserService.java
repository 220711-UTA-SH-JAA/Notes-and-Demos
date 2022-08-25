package com.example.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exceptions.InvalidCredentialsException;
import com.example.models.User;
import com.example.repository.UserRepository;

/*	Spring Data Annotations
 * 	- @Transactional: Configure how the database transaction behaves
 * 	- @NoRepositoryBean: Creates an interface that provides common methods for child repositories
 * 	- @Param: used to pass parameters to custom queries
 * 	- @Transient: Mark a field as a transient, aka to be ignore by the database
 * 	- @CreateBy, and @LastModifiedBy: Auditing annotations that will automatically fill with current date
 * 	- @Query: will allow you to create custom queries
 * 
 * @Transactional Additional information
 * 
 * When we are interacting with databases through java, we should expect that multiple transactions can occur at once
 * 
 * With @Transactional, we can allow Spring to manage these transactions for us to preven issues with little to no extra code
 * 
 * @Transactional, will essentially treat each method as their own transaction
 * 
 * It is best practice to use @Transactional over your service classes because this is where the database calls are occuring
 * 
 * @Transactional Attributes:
 * - isolation: isolation level
 * - noRollBackFor: defines 0 or more exceptions that will not rollback from
 * - propagation: the transaction propagation type (more on this)
 * - readOnly: boolean flag which will set the transaction to readOnly
 * - rollBackFor: define 0 or more exceptions which you do want a transaction to rollback for
 * - timeout: the timeout for the transaction
 * - transactionManager: if you want to specify a different one
 * 
 * Transaction Propagation Strategies
 *  When access a database in Java, it is common that you may have one service method calling another service method,
 *  these Transaction Propagation Strategies describe how Spring should handle these situations
 *  
 *  Strategies:
 *  - Mandatory: supports a current transaction, throw an exception if none exist
 *  - Nested: execute a nested transaction if a current one exists, other behave like required
 *  - Never: execute non-transactionally, if a transaction exists throw an exception
 *  - Not Supported: execute non-transactionally, if a transaction exists suspent it
 *  - Required: support a current transaction, create one if not exists
 *  - Requires New: create a new transaction, suspend the current if exists
 *  - Supports: Support a new transaction, execute non-transactionally if none exists 
 *  
 */

//Annotate this class for spring to manage
@Service
//With @Transactional, each method inside of this class will be treated as a single transaction
@Transactional
public class UserService {
	
	//Later on we will want to autowire our Repository, but for now we are moving forward
	private UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User registerUser(User u) {
		
		userRepo.save(u);
		
		return userRepo.getByUsername(u.getUsername()).get();
	}
	
	public User loginUser(String username, String password) {
		User u = userRepo.getByUsername(username).orElseThrow(InvalidCredentialsException::new);
		
		if(u.getPassword().equals(password)) {
			return u;
		}
		
		throw new InvalidCredentialsException();
		
	}
	
}
