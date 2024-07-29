package com.example.server.repositories;

import com.example.server.models.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepo extends JpaRepository<Follow, Integer> {

    Optional<List<Follow>> findByUser_Id (int user_id);
    Optional<Follow> findByUser_IdAndFollowing_Id (int user_id, int following_id);
}
