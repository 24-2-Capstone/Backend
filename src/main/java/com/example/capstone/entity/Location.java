package com.example.capstone.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int floor;

    private String location_detail;

    @OneToOne(mappedBy = "location")
    private Robot robot;

    @OneToMany(mappedBy = "locaiton", cascade = CascadeType.REMOVE)
    private List<Location> locations;
}
