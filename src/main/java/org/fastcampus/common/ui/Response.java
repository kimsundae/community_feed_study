package org.fastcampus.common.ui;

import org.fastcampus.common.domain.exception.ErrorCode;

public record Response<T>(Integer code, String message, T value) {

    public static <T> Response<T> ok(T value){
        return new Response<T>(0, "ok", value);
    }

    public static <T> Response<T> error(ErrorCode errorCode){
        return new Response<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

}
