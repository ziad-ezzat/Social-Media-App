package com.example.server.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Follow> following;

    @OneToMany(mappedBy = "following",cascade = CascadeType.ALL)
    Set<Follow> followers;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Post> posts;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Like> likes;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<UserImage> images;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Comment>comments;
}

/*
json example
{
    "id": 1,
    "name": "John",
    "lastName": "Doe",
    "email": "
    "password
}
 */