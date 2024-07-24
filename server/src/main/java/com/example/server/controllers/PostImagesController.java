package com.example.server.controllers;

import com.example.server.models.Post;
import com.example.server.models.PostImage;
import com.example.server.services.PostImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/postimages")
public class PostImagesController {

    @Autowired
    private PostImageService postImageService;

    @PostMapping("/upload")
    public ResponseEntity<PostImage> upload(@RequestParam("image") MultipartFile file, @RequestParam int postId) throws IOException {
        PostImage postImageResponse = postImageService.savePostImage(file, postId);
        return new ResponseEntity<>(postImageResponse, HttpStatus.OK);
    }

    @GetMapping("/download/{postId}")
    public ResponseEntity<?> download(@PathVariable int postId){
        byte[] image = postImageService.downloadPostImage(postId);
        if (image!=null){
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
}