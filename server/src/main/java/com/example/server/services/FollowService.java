package com.example.server.services;

import com.example.server.models.Follow;
import com.example.server.repositories.FollowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    @Autowired
    private FollowRepo followRepo;
    @Autowired
    private UserService userService;

    public void follow(int userId, int followingId) {
        if (userService.isFollowing(userId, followingId)) {
            followRepo.delete(followRepo.findByUser_IdAndFollowing_Id(userId,followingId).orElseThrow());
        } else {
            Follow follow = new Follow();
            follow.setUser(userService.getUserById(userId));
            follow.setFollowing(userService.getUserById(followingId));
            followRepo.save(follow);
        }
    }
}
