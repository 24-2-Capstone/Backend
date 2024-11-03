package com.example.capstone.service;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponseStatus;
import com.example.capstone.entity.Goods;
import com.example.capstone.entity.Location;
import com.example.capstone.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodsService {


    @Autowired
    private GoodsRepository goodsRepository;

    public Location getGoodsLocation(Long id) throws Exception {
        Optional<Goods> goods = goodsRepository.findById(id);

        if (goods.isPresent()) {
            return goods.get().getLocation();
        } else {
            throw new BaseException(BaseResponseStatus.NON_EXIST_GOODS);
        }
    }
}
