package com.example.server.services;

import com.example.server.ImageUtil;
import com.example.server.models.UserImage;
import com.example.server.repositories.UserImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserImageService {

    @Autowired
    private UserImageRepo userImageRepo;
    @Autowired
    private UserService userService;

    public UserImage saveUserImage(MultipartFile file, int userId) throws IOException {
        UserImage userImage = new UserImage();
        userImage.setData(ImageUtil.compressImage(file.getBytes()));
        userImage.setUser(userService.getUserById(userId));

        userImageRepo.save(userImage);
        return userImage;
    }

    public byte[] downloadUserImage(int id) {
        Optional<UserImage> userImage = userImageRepo.findByUser_id(id);
        return ImageUtil.decompressImage(userImage.orElse(null).getData());
    }
}
