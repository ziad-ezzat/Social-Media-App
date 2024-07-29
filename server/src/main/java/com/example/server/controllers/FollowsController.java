package com.example.server.controllers;

import com.example.server.models.Follow;
import com.example.server.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follows")
public class FollowsController {

    @Autowired
    private FollowService followService;

    //used **********
    @PostMapping("/follow")
    public ResponseEntity<String> follow(@RequestParam int userId, @RequestParam int followingId){
        followService.follow(userId, followingId);
        return new ResponseEntity<>("Followed", HttpStatus.OK);
    }
}
