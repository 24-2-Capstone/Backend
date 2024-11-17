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
    DELETE_SUCCESS(true, HttpStatus.OK.value(), "상품을 성공적으로 삭제했습니다."),

    // 4xx : client error
    HTTP_METHOD_ERROR(false, HttpStatus.FORBIDDEN.value(), "http 메서드가 올바르지 않습니다."),
    NON_EXIST_GOODS(false, HttpStatus.UNAUTHORIZED.value(), "존재하지 않는 상품입니다."),
    NON_EXIST_LOCATION(false, HttpStatus.UNAUTHORIZED.value(), "존재하지 않는 위치입니다."),
    NON_GOODS_BY_NAME(false, HttpStatus.UNAUTHORIZED.value(), "해당 이름인 상품이 존재하지 않습니다."),
    NO_GOODS_BY_CATEGORY(false, HttpStatus.UNAUTHORIZED.value(), "해당 카테고리의 상품이 존재하지 않습니다."),
    NON_CATEGORY_ERROR(false, HttpStatus.UNAUTHORIZED.value(), "해당 카테고리가 존재하지 않습니다."),

    // 5xx : server error
    SERVER_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버에 오류가 있습니다. 다시 시도해주세요."),
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
