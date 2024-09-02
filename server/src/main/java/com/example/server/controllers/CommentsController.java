//package com.example.server.controllers;
//
//import com.example.server.models.Comment;
//import com.example.server.services.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/comments")
//public class CommentsController {
//
//    @Autowired
//    private CommentService commentService;
//
//    @GetMapping("/getallbypost/{postId}")
//    public ResponseEntity<List<Comment>> getAllByPost(@PathVariable int postId){
//        return new ResponseEntity<>(commentService.getCommentsByPost(postId),HttpStatus.OK);
//    }
//
//    @GetMapping("/getallbyuser/{userId}")
//    public ResponseEntity<List<Comment>> getAllByUser(@PathVariable int userId){
//        return new ResponseEntity<>(commentService.getCommentsByUser(userId),HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String> add(@RequestBody Comment commentAddRequest){
//        commentService.saveComment(commentAddRequest);
//        return new ResponseEntity<>("Added",HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> delete(@RequestParam int id){
//        commentService.deleteComment(id);
//        return new ResponseEntity<>("Deleted",HttpStatus.OK);
//    }
//}
