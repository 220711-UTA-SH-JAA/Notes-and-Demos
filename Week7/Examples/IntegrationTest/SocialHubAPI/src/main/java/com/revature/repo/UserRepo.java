package com.revature.repo;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    //Start out with Basic crud just like in our original
    //Create is handled by the jparepository
    //Read all, and read by id was handed by jparepository
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

    //Update is also handled by jparepository
    //Delete is also handled by jparepository

}
