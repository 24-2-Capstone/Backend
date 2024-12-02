package com.example.capstone.dto.response;

import com.example.capstone.entity.Location;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RobotMoveResponse {
    private String url;
    private int x;
    private int y;

    @Builder
    public RobotMoveResponse(int x, int y) {
        this.url = "https://norchestra.maum.ai/harmonize/dosmart";
        this.x = x;
        this.y = y;
    }

    public static RobotMoveResponse toDto(Location location) {
        return RobotMoveResponse.builder()
                .x(location.getX())
                .y(location.getY())
                .build();
    }
}
