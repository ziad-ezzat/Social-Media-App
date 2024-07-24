package com.example.server.repositories;

import com.example.server.models.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserImageRepo extends JpaRepository<UserImage, Integer> {

    Optional<UserImage> findByUser_id(int user_id);
}
