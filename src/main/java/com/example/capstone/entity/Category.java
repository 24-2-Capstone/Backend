package com.example.capstone.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category_name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Goods> goodsList = new ArrayList<>();

    public Category(Long id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }
}
