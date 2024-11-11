package com.example.capstone.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Robot")
public class Robot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "robot_id")
    private Long id; // 로봇의 id는 요청이 들어올때마다 하나씩 증가, 즉 요청 하나당 id 값을 가지게 됨.

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Builder
    public Robot(String status, Chat chat, Location location) {
        this.status = status;
        this.location = location;
    }
}
