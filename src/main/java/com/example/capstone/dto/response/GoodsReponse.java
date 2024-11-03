package com.example.capstone.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsReponse {
    private String goods_description;

    private String goods_name;

    private int stock_state;

    private String goods_note;

    private String goods_price;

    @Builder
    private GoodsReponse(String goods_description, String goods_name, int stock_state, String goods_note, String goods_price) {
        this.goods_description = goods_description;
        this.goods_name = goods_name;
        this.stock_state = stock_state;
        this.goods_note = goods_note;
        this.goods_price = goods_price;
    }
}
