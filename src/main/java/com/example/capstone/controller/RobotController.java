package com.example.capstone.controller;


import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponse;
import com.example.capstone.dto.response.LocationDto;
import com.example.capstone.service.RobotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RobotController {

    private final RobotService robotService;

    @PostMapping("/robot/move-to-goods/{goodsId}")
    public BaseResponse<LocationDto> moveRobotToGoods(@PathVariable Long goodsId) {
        try {
            return new BaseResponse<>(robotService.moveRobotToGoodsLocation(goodsId));
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
