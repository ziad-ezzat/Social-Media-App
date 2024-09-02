//package com.example.server.repositories;
//
//import com.example.server.models.Comment;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CommentRepo extends JpaRepository<Comment, Integer> {
//
//    void deleteById(int id);
//    Optional<List<Comment>> findByPostId (int postId);
//    Optional<List<Comment>> findByUser_Id (int user_id);
//}
