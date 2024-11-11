package com.example.capstone.controller;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponse;
import com.example.capstone.dto.response.LocationDto;
import com.example.capstone.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/goods/location/{id}")
    public BaseResponse<LocationDto> getGoodsLocation(@PathVariable Long id) {
        try {
            return new BaseResponse<>(locationService.getGoodsLocation(id));
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
