package com.example.server.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "created_at")
    private String createdAt;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    Set<Like> likes;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    Set<PostImage> postImages;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    Set<Comment> comments;
}
