package com.example.capstone.service;

import com.example.capstone.common.exception.BaseException;
import com.example.capstone.common.response.BaseResponseStatus;
import com.example.capstone.dto.response.LocationDto;
import com.example.capstone.entity.Category;
import com.example.capstone.entity.Goods;
import com.example.capstone.entity.Location;
import com.example.capstone.repository.GoodsRepository;
import com.example.capstone.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    private final GoodsRepository goodsRepository;

    public LocationDto getGoodsLocation(Long id) throws BaseException {
        Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NON_EXIST_GOODS));

        Long locationId = goods.getLocation().getId();

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NON_EXIST_LOCATION));

        Category category = location.getCategory();

        if (location != null) {
            return LocationDto.toLocationDto(location, category);
        } else {
            throw new BaseException(BaseResponseStatus.NON_EXIST_LOCATION);
        }
    }
}
