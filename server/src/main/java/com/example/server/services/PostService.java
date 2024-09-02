package com.example.server.services;

import com.example.server.models.Post;
import com.example.server.models.User;
import com.example.server.repositories.PostRepo;
import com.example.server.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    public Post savePost(Long userId, Post post) {
        Optional<User> user = userRepo.findById(userId);

        if (user.isPresent()) {
            post.setUser(user.get());
            post.setCreatedAt(LocalDateTime.now());
            return postRepo.save(post);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    public List<Post> getAllPosts() {
        return postRepo.findAllByOrderByCreatedAtDesc();
    }
}
