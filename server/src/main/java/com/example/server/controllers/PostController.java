package com.example.server.controllers;

import com.example.server.models.Post;
import com.example.server.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user")
    public Post createPost(@RequestParam Long userId, @RequestBody Post post) {
        return postService.savePost(userId, post);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}
