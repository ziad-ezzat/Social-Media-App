package com.example.server.services;

import com.example.server.models.Follow;
import com.example.server.models.Post;
import com.example.server.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PostService {

    @Autowired
    private final PostRepo postRepo;

    @Autowired
    private final UserService userService;

    public PostService(PostRepo postRepo, UserService userService) {
        this.postRepo = postRepo;
        this.userService = userService;
    }

    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    public Post getPostById(int id) {
        return postRepo.findById(id).orElse(null);
    }

    public List<Post> getPostsByUser(int userId) {
        return postRepo.findByUser_idOOrderByCreatedAtDesc(userId).orElseThrow();
    }

    public List<Post> getPostsByFollowing(int userId) {

        Set<Follow> following = userService.getFollowing(userId);
        List<Post> posts = new ArrayList<>();

        for (Follow follow : following) {
            posts.addAll(postRepo.findByUser_idOOrderByCreatedAtDesc(follow.getFollowing().getId()).orElseThrow());
        }

        return posts;
    }

    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    public void deletePost(int id) {
        postRepo.deleteById(id);
    }
}
