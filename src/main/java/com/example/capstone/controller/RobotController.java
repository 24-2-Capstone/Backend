package com.example.capstone.controller;


import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponse;
import com.example.capstone.common.response.BaseResponseStatus;
import com.example.capstone.service.RobotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RobotController {

    private final RobotService robotService;

    @PostMapping("/robot/{robotId}/move-to-goods/{goodsId}")
    public BaseResponse<String> moveRobotToGoods(@PathVariable Long robotId, @PathVariable Long goodsId) {
        try {
            robotService.moveRobotToGoodsLocation(robotId, goodsId);
            return new BaseResponse<>(BaseResponseStatus.SUCCESS);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
