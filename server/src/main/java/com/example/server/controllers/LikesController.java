//package com.example.server.controllers;
//
//import com.example.server.models.Like;
//import com.example.server.services.LikeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/likes")
//public class LikesController {
//
//    @Autowired
//    private LikeService likeService;
//
//    @PostMapping("/add")
//    public ResponseEntity<String> add(@RequestBody Like likeRequest){
//        likeService.saveLike(likeRequest);
//        return new ResponseEntity<>("Added", HttpStatus.OK);
//    }
//
//    @GetMapping("/getallbypost/{postId}")
//    public ResponseEntity<List<Like>> getAllByPost(@PathVariable int postId){
//        return new ResponseEntity<>(likeService.getLikesByPost(postId),HttpStatus.OK);
//    }
//
//    @GetMapping("/getallbyuser/{userId}")
//    public ResponseEntity<List<Like>> getAllByUser(@PathVariable int userId){
//        return new ResponseEntity<>(likeService.getLikesByUser(userId),HttpStatus.OK);
//    }
//
//    @GetMapping("/isliked")
//    public ResponseEntity<Boolean> isLiked(@RequestParam int userId,@RequestParam int postId){
//        return new ResponseEntity<>(likeService.isLiked(userId,postId),HttpStatus.OK);
//    }
//}
//
