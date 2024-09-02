//package com.example.server.services;
//
//import com.example.server.models.Follow;
//import com.example.server.repositories.FollowRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FollowService {
//
//    @Autowired
//    private FollowRepo followRepo;
//    @Autowired
//    private UserService userService;
//
//    public String followAndUnfollow(int userId, int followingId) {
//        if (userService.isFollowing(userId, followingId)) {
//            Follow follow = followRepo.findByUserIdAndFollowingId(userId, followingId).orElseThrow(() -> new RuntimeException("Follow not found"));
//            System.out.println(follow.getId());
//            followRepo.delete(follow);
//            return "Unfollowed";
//        } else {
//            Follow follow = new Follow();
//            follow.setUser(userService.getUserById(userId));
//            follow.setFollowing(userService.getUserById(followingId));
//            followRepo.save(follow);
//            return "Followed";
//        }
//    }
//}