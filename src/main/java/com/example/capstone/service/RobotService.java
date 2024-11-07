package com.example.capstone.service;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponseStatus;
import com.example.capstone.entity.Goods;
import com.example.capstone.entity.Location;
import com.example.capstone.entity.Robot;
import com.example.capstone.repository.GoodsRepository;
import com.example.capstone.repository.RobotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RobotService {

    private final RobotRepository robotRepository;
    private final GoodsRepository goodsRepository;

    public void moveRobotToGoodsLocation(Long robotId, Long goodsId) throws BaseException {
        Optional<Goods> goods = goodsRepository.findById(goodsId);
        if (goods.isEmpty()) {
            throw new BaseException(BaseResponseStatus.NON_EXIST_GOODS);
        }

        Location location = goods.get().getLocation();


        /* 로봇 이동 관련 API 추가*/


        if (robotRepository.findById(robotId).isPresent()) {
            Robot robot = robotRepository.findById(robotId).get();
            robot.setStatus("Moving to location: " + location.toString());
            robotRepository.save(robot);
        } else { // 로봇에게 들어온 요청이 존재하지 않는 경우는 없으므로, 서버 오류라고 판단.
            throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
