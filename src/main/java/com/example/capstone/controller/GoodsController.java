package com.example.capstone.controller;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponse;
import com.example.capstone.common.response.BaseResponseStatus;
import com.example.capstone.dto.response.GoodsResponse;
import com.example.capstone.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @DeleteMapping("/goods/delete/{id}")
    public BaseResponse<String> deleteGoods(@PathVariable Long id) {
        try {
            goodsService.deleteGoods(id);
            return new BaseResponse<>(BaseResponseStatus.DELETE_SUCCESS);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @GetMapping("/goods/search/name")
    public BaseResponse<GoodsResponse> searchGoodsByName(@RequestParam String goods_name) {
        try {
            GoodsResponse goodsResponse = goodsService.searchGoodsByName(goods_name);

            return new BaseResponse<>(goodsResponse);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @GetMapping("/goods/search/category")
    public BaseResponse<List<GoodsResponse>> searchGoodsListByCategory(@RequestParam String category) {
        try {
            List<GoodsResponse> goodsList = goodsService.searchGoodsListByCategory(category);
            return new BaseResponse<>(goodsList);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @GetMapping("/goods/search/keyword")
    public BaseResponse<List<GoodsResponse>> searchGoodsListByKeyword(@RequestParam String keyword) {
        try {
            List<GoodsResponse> goodsList = goodsService.searchGoodsListByKeyword(keyword);
            return new BaseResponse<>(goodsList);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
