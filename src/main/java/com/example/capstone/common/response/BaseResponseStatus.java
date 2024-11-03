package com.example.capstone.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseResponseStatus {

    /**
     * 성공 코드 2xx
     * 코드의 원활한 이해을 위해 code는 숫자가 아닌 아래 형태로 입력해주세요.
     */
    SUCCESS(true, HttpStatus.OK.value(), "요청에 성공하였습니다."),

    // 4xx : client error
    FAIL_TOKEN_AUTHORIZATION(false, HttpStatus.UNAUTHORIZED.value(), "토큰 인증에 실패하였습니다."),

    EXIST_EMAIL(false, HttpStatus.CONFLICT.value(), "이미 존재하는 회원입니다."),
    EXIST_NICKNAME(false, HttpStatus.CONFLICT.value(), "이미 존재하는 닉네임입니다."),

    NON_EXIST_USER(false, HttpStatus.UNAUTHORIZED.value(), "존재하지 않는 회원입니다."),
    HTTP_METHOD_ERROR(false, HttpStatus.FORBIDDEN.value(), "http 메서드가 올바르지 않습니다."),
    NON_EXIST_GOODS(false, HttpStatus.UNAUTHORIZED.value(), "존재하지 않는 상품입니다."),

    // 5xx : server error
    DATABASE_INSERT_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "데이터베이스 입력에 실패했습니다."),
    IMAGE_RECOGNITION_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "이미지 인식에 실패했습니다."),
    NON_EXIST_GOODS_INFORMATION(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "상품에 대한 정보를 찾을 수 없습니다."),
    CANNOT_SEARCH_GOODS_INFORMATION(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "현재 상품 정보를 검색할 수 없습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    /**
     * isSuccess : 요청의 성공 또는 실패
     * code : Http Status Code
     * message : 설명
     */
    BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
