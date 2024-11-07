package com.example.capstone.service;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponseStatus;
import com.example.capstone.dto.response.GoodsResponse;
import com.example.capstone.entity.Goods;
import com.example.capstone.entity.Location;
import com.example.capstone.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodsService {
    // try catch로 수정해보기

    private GoodsRepository goodsRepository;

    public Location getGoodsLocation(Long id) throws Exception {
        Optional<Goods> goods = goodsRepository.findById(id);

        if (goods.isPresent()) {
            return goods.get().getLocation();
        } else {
            throw new BaseException(BaseResponseStatus.NON_EXIST_GOODS);
        }
    }

    public void deleteGoods(Long id) throws BaseException {
        if (goodsRepository.existsById(id)) {
            goodsRepository.deleteById(id);
        } else {
            throw new BaseException(BaseResponseStatus.NON_EXIST_GOODS);
        }
    }

    public List<GoodsResponse> searchGoodsByName(String goods_name) {
        List<GoodsResponse> GoodsListFindByGoodName = goodsRepository.findByGoodsName(goods_name)
                .stream()
                .map(goods -> GoodsResponse.entityToDto(goods))
                .toList();
        if (GoodsListFindByGoodName.isEmpty()) {
            throw new BaseException(BaseResponseStatus.NON_GOODS_BY_NAME);
        }
        return GoodsListFindByGoodName;
    }
}
