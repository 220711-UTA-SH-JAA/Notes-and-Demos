package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.GroceryList;
import com.example.models.User;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Integer>{

	List<GroceryList> getByUser(User u);
	
	Optional<GroceryList> getByListName(String listName);
	
}
