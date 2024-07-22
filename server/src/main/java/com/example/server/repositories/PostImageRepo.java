package com.example.server.repositories;

import com.example.server.models.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostImageRepo extends JpaRepository<PostImage, Integer> {

    Optional<PostImage> findPostImageByPostId(int postId);
}
