package com.example.capstone.controller;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponse;
import com.example.capstone.entity.Location;
import com.example.capstone.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

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
}
