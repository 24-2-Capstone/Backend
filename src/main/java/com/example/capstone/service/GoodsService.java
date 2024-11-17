package com.example.capstone.service;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponseStatus;
import com.example.capstone.dto.response.GoodsResponse;
import com.example.capstone.entity.Category;
import com.example.capstone.entity.Goods;
import com.example.capstone.repository.CategoryRepository;
import com.example.capstone.repository.GoodsRepository;
import com.example.capstone.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsService {
    // try catch로 수정해보기

    private final GoodsRepository goodsRepository;

    private final LocationRepository locationRepository;

    private final CategoryRepository categoryRepository;

    public void deleteGoods(Long id) throws BaseException {
        if (goodsRepository.existsById(id)) {
            goodsRepository.deleteById(id);
        } else {
            throw new BaseException(BaseResponseStatus.NON_EXIST_GOODS);
        }
    }

    public GoodsResponse searchGoodsByName(String goods_name) {
        Goods goods = goodsRepository.findByName(goods_name)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NON_GOODS_BY_NAME));

        return GoodsResponse.entityToDto(goods);
    }

    public List<GoodsResponse> searchGoodsListByCategory(String category) {
        Category c = categoryRepository.findByCategoryName(category)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NON_CATEGORY_ERROR));

        List<GoodsResponse> goodsResponseListByCategory = goodsRepository.findByCategoryId(c.getId())
                .stream()
                .map(goods -> GoodsResponse.entityToDto(goods))
                .toList();

        return goodsResponseListByCategory;
    }

    public List<GoodsResponse> searchGoodsListByKeyword(String keyword) {
        List<Goods> goodsList = goodsRepository.findByNameContaining(keyword);

        List<GoodsResponse> goodsResponseList = goodsList
                .stream()
                .map(goods -> GoodsResponse.entityToDto(goods))
                .toList();

        return goodsResponseList;
    }

    public List<GoodsResponse> getAllGoods() {

        return goodsRepository.findAll()
                .stream()
                .map(GoodsResponse::entityToDto)
                .toList();
    }
}
