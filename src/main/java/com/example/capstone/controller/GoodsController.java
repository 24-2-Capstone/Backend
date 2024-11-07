package com.example.capstone.controller;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponse;
import com.example.capstone.dto.response.GoodsResponse;
import com.example.capstone.entity.Goods;
import com.example.capstone.entity.Location;
import com.example.capstone.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping("/goods/{id}/location")
    public BaseResponse<Location> getGoodsLocation(@PathVariable Long id) throws Exception {
        try {
            Location location = goodsService.getGoodsLocation(id);
            return new BaseResponse<>(location);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @DeleteMapping("/goods/{id}")
    public BaseResponse<String> deleteGoods(@PathVariable Long id) {
        try {
            goodsService.deleteGoods(id);
            return new BaseResponse<>("Goods successfully deleted.");
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @GetMapping("/goods/search")
    public BaseResponse<List<GoodsResponse>> searchGoodsByName(@RequestParam String goods_name) {

        try {
            List<GoodsResponse> goodsList = goodsService.searchGoodsByName(goods_name);
            return new BaseResponse<>(goodsList);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }

    }
}
