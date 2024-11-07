package com.example.capstone.entity;

import com.example.capstone.dto.request.GoodsListDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goods_description;

    private String goods_name;

    private int stock_state;

    private String goods_note;

    private String goods_price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Builder
    public Goods(Long id, String goods_description, String goods_name, int stock_state, String goods_note, String goods_price) {
        this.id = id;
        this.goods_description = goods_description;
        this.goods_name = goods_name;
        this.stock_state = stock_state;
        this.goods_note = goods_note;
        this.goods_price = goods_price;
    }

    public static Goods dtoToEntity(GoodsListDto dto) {
        return Goods.builder()
                .goods_name(dto.getGoods_name())
                .goods_description(dto.getGoods_description())
                .stock_state(dto.getStock_state())
                .goods_note(dto.getGoods_note())
                .goods_price(dto.getGoods_price())
                .build();
    }
}
