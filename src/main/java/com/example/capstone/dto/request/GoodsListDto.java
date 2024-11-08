package com.example.capstone.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsListDto {

    private String goods_name;

    private String goods_description;

    private int stock_state;

    private int goods_price;

    private int salePrice;

    private boolean isSale;

    private String imageURL;

}
