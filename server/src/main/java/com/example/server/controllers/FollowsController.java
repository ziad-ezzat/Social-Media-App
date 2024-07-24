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

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Follow followRequest){
        followService.saveFollow(followRequest);
        return new ResponseEntity<>("Followed", HttpStatus.OK);
    }
}
