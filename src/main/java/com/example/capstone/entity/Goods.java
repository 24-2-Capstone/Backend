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
    @Column(name = "goods_id")
    private Long id;

    @Column(name = "goods_description")
    private String goods_description;

    @Column(name = "goods_name")
    private String name;

    @Column(name = "stock_state")
    private int stock_state;

    @Column(name = "goods_price")
    private int goods_price;

    @Column(name = "sale_price")
    private int sale_price;

    @Column(name = "imageURL")
    private String imageURL;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Builder
    public Goods(Long id, String goods_description, String goods_name, int stock_state, int goods_price, int salePrice, String imageURL) {
        this.id = id;
        this.goods_description = goods_description;
        this.name = goods_name;
        this.stock_state = stock_state;
        this.goods_price = goods_price;
        this.sale_price = salePrice;
        this.imageURL = imageURL;
    }

    public static Goods dtoToEntity(GoodsListDto dto) {
        return Goods.builder()
                .goods_name(dto.getGoods_name())
                .goods_description(dto.getGoods_description())
                .stock_state(dto.getStock_state())
                .goods_price(dto.getGoods_price())
                .salePrice(dto.getSalePrice())
                .imageURL(dto.getImageURL())
                .build();
    }
}
