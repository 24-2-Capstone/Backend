package com.example.capstone.service;

import com.example.capstone.dto.response.RobotMoveResponse;
import com.example.capstone.entity.Goods;
import com.example.capstone.entity.Location;
import com.example.capstone.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RobotService {

    private final GoodsRepository goodsRepository;

    public RobotMoveResponse moveRobotToGoodsLocation(Long id) {
        Goods goods = goodsRepository.findById(id).get();
        Location location = goods.getLocation();

        return RobotMoveResponse.toDto(location);
    }
}
