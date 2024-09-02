//package com.example.server.repositories;
//
//import com.example.server.models.Follow;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface FollowRepo extends JpaRepository<Follow, Integer> {
//
//    Optional<Follow> findByUserIdAndFollowingId(int userId, int followingId);
//}