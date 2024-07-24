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

    public Follow saveFollow(Follow follow) {
        if (userService.isFollowing(follow.getUser().getId(), follow.getFollowing().getId())) {
            followRepo.delete(followRepo.findByUser_IdAndFollowing_Id(follow.getUser().getId(), follow.getFollowing().getId()).orElseThrow().get(0));
            return null;
        } else {
            return followRepo.save(follow);
        }
    }
}
