package com.example.server.controllers;

import com.example.server.models.User;
import com.example.server.responses.UserResponse;
import com.example.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    //used **********
    @GetMapping("/getAll_except_userFollowings")
    public ResponseEntity<List<UserResponse>> getAllExceptUserFollowings(@RequestParam int userId){
        return ResponseEntity.ok(userService.getUsersExceptUserFollowings(userId));
    }

//    @GetMapping("/getbyid/{id}")
//    public ResponseEntity<User> getById(@PathVariable int id){
//        return ResponseEntity.ok(userService.getUserById(id));
//    }
//
//    @GetMapping("/isfollowing")
//    public ResponseEntity<Boolean> isFollowing(@RequestParam int userId,@RequestParam int followingId){
//        return ResponseEntity.ok(userService.isFollowing(userId,followingId));
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String> add(@RequestBody User user){
//        userService.saveUser(user);
//        return ResponseEntity.ok("User added successfully");
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<Void> delete(@RequestParam int id){
//        userService.deleteUser(id);
//        return ResponseEntity.ok().build();
//    }
}
