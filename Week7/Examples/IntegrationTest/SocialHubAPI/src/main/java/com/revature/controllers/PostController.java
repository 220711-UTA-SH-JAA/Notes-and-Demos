package com.revature.controllers;

import com.revature.models.Post;
import com.revature.models.PostWithUsername;
import com.revature.models.User;
import com.revature.services.PostService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private PostService ps;

    @Autowired
    public PostController(PostService ps){
        this.ps = ps;
    }

    @PostMapping("/post")
    public Post handleCreatePost(@RequestParam(name="user")int userId, @RequestBody Post body){
        return ps.createNewPost(userId, body.getContent(), body.getPostedDate());
    }

    @GetMapping("/posts/user/{id}")
    public List<PostWithUsername> getAllFromUser(@PathVariable("id")int id){
        List<Post> posts = ps.getAllBySpecifiedUser(id);
        List<PostWithUsername> toSendBack = new ArrayList<>();
        for(Post p: posts){
            toSendBack.add(new PostWithUsername(p.getPostId(), p.getContent(), p.getPostUser().getUsername(), p.getPostedDate()));
        }

        return toSendBack;
    }

    @GetMapping("/posts/following/{id}")
    public List<PostWithUsername> getAllPostsFromFollowingList(@PathVariable("id")int id){
        List<Post> posts = ps.getFollowersPosts(id);
        List<PostWithUsername> toSendBack = new ArrayList<>();
        for(Post p: posts){
            toSendBack.add(new PostWithUsername(p.getPostId(), p.getContent(), p.getPostUser().getUsername(), p.getPostedDate()));
        }

        return toSendBack;
    }

}
