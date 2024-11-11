package com.example.capstone.dto.response;

import com.example.capstone.entity.Location;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LocationDto {

    private Long id;
    private int x;
    private int y;

    @Builder
    public LocationDto(Long id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public static LocationDto toLocationDto(Location location) {
        return LocationDto.builder()
                .id(location.getId())
                .x(location.getX())
                .y(location.getY())
                .build();
    }
}
