//package com.example.server.repositories;
//
//import com.example.server.models.Like;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface LikeRepo extends JpaRepository<Like, Integer> {
//
//    void deleteById (int id);
//    Optional<List<Like>> findByPost_Id (int postId);
//    Optional<List<Like>> findByUser_Id (int user_id);
//    Optional<Like> findByUserIdAndPostId(int userId, int postId);
//}
