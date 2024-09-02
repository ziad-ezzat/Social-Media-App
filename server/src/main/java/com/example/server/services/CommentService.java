//package com.example.server.services;
//
//import com.example.server.models.Comment;
//import com.example.server.repositories.CommentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CommentService {
//
//    @Autowired
//    private CommentRepo commentRepo;
//
//    public Comment saveComment(Comment comment) {
//        return commentRepo.save(comment);
//    }
//
//    public List<Comment> getCommentsByPost(int postId) {
//        return commentRepo.findByPostId(postId).orElseThrow();
//    }
//
//    public List<Comment> getCommentsByUser(int userId) {
//        return commentRepo.findByUser_Id(userId).orElseThrow();
//    }
//
//    public void deleteComment(int id) {
//        commentRepo.deleteById(id);
//    }
//}
