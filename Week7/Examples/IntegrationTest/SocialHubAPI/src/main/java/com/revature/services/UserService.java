package com.revature.services;

import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.InvalidUserException;
import com.revature.models.User;
import com.revature.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class UserService {

    private UserRepo ur;

    @Autowired
    public UserService(UserRepo ur){
        this.ur = ur;
    }

    //Register
    public User registerNewUser(String first, String last, String username, String email, String password){

        User register = new User(first, last, username, email, password);
        return ur.save(register);
    }


    //Login
    public User loginUser(String username, String password){
        User loggedIn = ur.findUserByUsernameAndPassword(username, password);

        if(loggedIn == null){
            throw new InvalidCredentialsException();
        }

        return loggedIn;
    }


    //update

    public User followUser(int currentUserId, int followingUserId){

        User current = ur.findById(currentUserId).get();
        User following = ur.findById(followingUserId).get();


        Set<User> addToFollowing = current.getFollowing();
        addToFollowing.add(following);
        current.setFollowing(addToFollowing);

        Set<User> addToFollowers = following.getFollowers();
        addToFollowers.add(current);
        following.setFollowers(addToFollowers);

        //With JPA .save will either save a new entity, or it will update if the entity already exists
        ur.save(following);

        return ur.save(current);

    }

    public User getCurrentUserById(int id){
        return ur.findById(id).get();
    }

    //delete

}
