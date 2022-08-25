package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.User;

/*	Spring Data
 * 	Spring Data is NOT a core spring frameworks
 * 	
 * 	It is family of frameworks for ORM and data persistance whos main purpose is abstract away as much query information as possible
 * 	- Allows us to focus on business logic
 * 
 * 	We are specifically learning Spring Data JPA

	It essentially abstracts away the use of hibernate and SpringORM, simplifying your Data Access Layer and providing standard implementations for common DAO methods

	This means you no longer have to implement these, they are simply provided for you extending the JpaRepository

	When you extend JpaRepository Spring will automatically create an implementation for youe DAO, include CRUD for standard data access, as custom queries based off of method signatures.
 * 
 * Spring Data JPA Methods:
 * - Predefined CRUD methods
 * - Custom method sigantures
 * - Custom queries with @Query
 * 
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//If we wanted a custom query we could do something like this
	Optional<User> getByUsername(String username);

}
