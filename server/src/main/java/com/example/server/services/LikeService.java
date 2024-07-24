package com.example.server.services;

import com.example.server.models.Like;
import com.example.server.repositories.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepo likeRepo;

    public List<Like> getLikesByPost(int postId) {
        return likeRepo.findByPost_Id(postId).orElseThrow();
    }

    public List<Like> getLikesByUser(int userId) {
        return likeRepo.findByUser_Id(userId).orElseThrow();
    }

    public boolean isLiked(int userId, int postId) {
        return likeRepo.findByUserIdAndPostId(userId, postId).isPresent();
    }

    public Like saveLike(Like like) {
        if (isLiked(like.getUser().getId(), like.getPost().getId())) {
            likeRepo.deleteById(likeRepo.findByUserIdAndPostId(like.getUser().getId(), like.getPost().getId()).orElseThrow().getId());
            return null;
        } else {
            return likeRepo.save(like);
        }
    }
}
