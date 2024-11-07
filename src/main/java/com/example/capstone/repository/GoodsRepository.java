package com.example.capstone.repository;

import com.example.capstone.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findByGoodsName(String goods_name);

    List<Goods> findByCategory(String category);
}
