package com.example.server.repositories;

import com.example.server.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PostRepo extends JpaRepository<Post, Integer> {

    Optional<List<Post>> findByUser_IdOrderByCreatedAtDesc (int id);

    void deleteById(int id);
}