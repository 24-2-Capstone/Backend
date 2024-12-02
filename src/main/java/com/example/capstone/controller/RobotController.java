package com.example.capstone.controller;


import com.example.capstone.common.response.BaseResponse;
import com.example.capstone.dto.response.RobotMoveResponse;
import com.example.capstone.service.RobotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RobotController {

    private final RobotService robotService;

    @PostMapping("/robot/move-to-goods/{id}")
    public BaseResponse<?> moveRobotToGoods(@PathVariable Long id) {
        RobotMoveResponse response = robotService.moveRobotToGoodsLocation(id);

        return new BaseResponse<>(response);
    }
}
