package com.example.capstone.dto.response;

import com.example.capstone.entity.Goods;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsResponse {
    private String goods_description;

    private String goods_name;

    private int stock_state;

    private String goods_note;

    private String goods_price;

    @Builder
    private GoodsResponse(String goods_description, String goods_name, int stock_state, String goods_note, String goods_price) {
        this.goods_description = goods_description;
        this.goods_name = goods_name;
        this.stock_state = stock_state;
        this.goods_note = goods_note;
        this.goods_price = goods_price;
    }

    public static GoodsResponse entityToDto(Goods goods) {
        return GoodsResponse.builder()
                .goods_name(goods.getGoods_name())
                .goods_description(goods.getGoods_description())
                .stock_state(goods.getStock_state())
                .goods_note(goods.getGoods_note())
                .goods_price(goods.getGoods_price())
                .build();
    }
}
