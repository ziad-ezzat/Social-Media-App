package com.example.server.controllers;

import com.example.server.models.UserImage;
import com.example.server.services.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/userimages")
public class UserImagesController {

    @Autowired
    private UserImageService userImageService;

    @PostMapping("/upload")
    public ResponseEntity<UserImage> upload(@RequestParam("image")MultipartFile file, @RequestParam int userId) throws IOException {
        UserImage response = userImageService.saveUserImage(file, userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/download/{userId}")
    public ResponseEntity<byte[]> download(@PathVariable int userId){
        byte[] image = userImageService.downloadUserImage(userId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}