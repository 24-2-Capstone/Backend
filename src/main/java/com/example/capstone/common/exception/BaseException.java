package com.example.capstone.common.exception;

import com.example.capstone.common.response.BaseResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {

    BaseResponseStatus status;
    
    /**
     * throw new BaseException(BaseResponseStatus.DATABASE_INSERT_ERROR)와 같이 사용.
     */
    public BaseException(BaseResponseStatus status) {
        super(status.getMessage());
        this.status = status;
    }
}
