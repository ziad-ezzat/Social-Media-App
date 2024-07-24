package com.example.server.services;

import com.example.server.ImageUtil;
import com.example.server.models.PostImage;
import com.example.server.repositories.PostImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PostImageService {

    @Autowired
    private PostImageRepo postImageRepo;
    @Autowired
    private PostService postService;

    public PostImage savePostImage(MultipartFile file, int postId) throws IOException {
        PostImage postImage = new PostImage();
        postImage.setData(ImageUtil.compressImage(file.getBytes()));
        postImage.setPost(postService.getPostById(postId));

        postImageRepo.save(postImage);

        return postImage;
    }

    public byte[] downloadPostImage(int id) {
        return ImageUtil.decompressImage(postImageRepo.findPostImageByPostId(id).orElse(null).getData());
    }
}
