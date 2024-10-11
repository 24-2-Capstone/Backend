package com.example.capstone.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// @Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ChatLog;

    boolean isAdmin;

    @OneToMany(mappedBy = "User", cascade = CascadeType.REMOVE)
    private List<Chat> chatList;

    @Builder
    private User(Long id, String chatLog, boolean isAdmin) {
        this.id = id;
        this.ChatLog = chatLog;
        this.isAdmin = isAdmin;
    }
}
