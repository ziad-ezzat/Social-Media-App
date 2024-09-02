//package com.example.server.models;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "follows")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Follow {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonBackReference
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "following_id")
//    @JsonBackReference
//    private User following;
//}