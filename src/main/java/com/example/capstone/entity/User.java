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
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    boolean isAdmin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Chat> chatList = new ArrayList<>();

    @Builder
    private User(Long id, boolean isAdmin) {
        this.id = id;
        this.isAdmin = isAdmin;
    }
}
