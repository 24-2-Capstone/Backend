package com.example.capstone.repository;

import com.example.capstone.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Optional<Goods> findByName(String name);

    List<Goods> findByCategoryId(Long id);

    List<Goods> findByNameContaining(String keyword);
}
