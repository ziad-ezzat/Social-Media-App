package com.example.server.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comments")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "description")
    private String description;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;
}
