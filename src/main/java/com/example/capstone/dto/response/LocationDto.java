package com.example.capstone.dto.response;

import com.example.capstone.entity.Category;
import com.example.capstone.entity.Location;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LocationDto {

    private Long id;
    private String name;
    private int x;
    private int y;

    @Builder
    public LocationDto(Long id, String name, int x, int y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public static LocationDto toLocationDto(Location location, Category category) {
        return LocationDto.builder()
                .id(location.getId())
                .name(category.getCategoryName())
                .x(location.getX())
                .y(location.getY())
                .build();
    }
}
