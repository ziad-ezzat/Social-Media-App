package com.example.server.controllers;

import com.example.server.models.Post;
import com.example.server.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    private PostService postService;

    @GetMapping("/getall")
    public ResponseEntity<List<Post>> getAll(){
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Post> getById(@PathVariable int id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @GetMapping("/getallbyuser/{userId}")
    public ResponseEntity<List<Post>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(postService.getPostsByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/getbyuserfollowing/{userId}")
    public ResponseEntity<List<Post>> getAllByUserFollowing(@PathVariable int userId){
        return new ResponseEntity<>(postService.getPostsByFollowing(userId),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> add(@RequestBody Post post){
        Post postAdded = postService.savePost(post);
        return new ResponseEntity<>(postAdded,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        postService.deletePost(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}