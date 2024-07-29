package com.example.server.services;

import com.example.server.mappers.UserMapper;
import com.example.server.models.Follow;
import com.example.server.models.User;
import com.example.server.repositories.UserRepo;
import com.example.server.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<UserResponse> getUsersExceptUserFollowings(int userId) {

        List<UserResponse> users = new java.util.ArrayList<>(userRepo.findAll().stream().map(UserMapper::toUserResponse).toList());
        User user = userRepo.findById(userId).orElse(null);
        users.removeIf(userResponse -> userResponse.getId() == userId);
        if (user != null) {
            Set<Follow> followings = user.getFollowing();
            users.removeIf(userResponse -> followings.stream().anyMatch(follow -> follow.getFollowing().getId() == userResponse.getId()));
        }

        return users;
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }
//
//    public User getUserByEmail(String username) {
//        return userRepo.findByEmail(username).orElse(null);
//    }
//
//    public Set<Follow> getFollowers(int id) {
//        return Objects.requireNonNull(userRepo.findById(id).orElse(null)).getFollowers();
//    }
//
    public Set<Follow> getFollowing(int id) {
        return Objects.requireNonNull(userRepo.findById(id).orElse(null)).getFollowing();
    }
//
    public boolean isFollowing(int id, int followingId) {
        return Objects.requireNonNull(userRepo.findById(id).orElse(null)).getFollowing().stream().anyMatch(follow -> follow.getFollowing().getId() == followingId);
    }
//
//    public User saveUser(User user) {
//        return userRepo.save(user);
//    }
//
//    public void deleteUser(int id) {
//        userRepo.deleteById(id);
//    }
}

