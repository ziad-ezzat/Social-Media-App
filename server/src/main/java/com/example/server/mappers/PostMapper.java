//package com.example.server.mappers;
//
//import com.example.server.models.Post;
//import com.example.server.requests.PostRequest;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class PostMapper {
//    public static Post toPost(PostRequest postRequest){
//        Post post = new Post();
//        post.setDescription(postRequest.getDescription());
//        post.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        return post;
//    }
//}
