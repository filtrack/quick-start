package com.app.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {

    //返回码
    private Integer code;
    //返回信息
    private String message;
    //返回对象
    private T data;

    public static <T> CommonResult<T> success() {
        return createResult(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static <T> CommonResult<T> success(T data) {
        return createResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> success(String message) {
        return createResult(ResponseCode.SUCCESS.getCode(), message, null);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return createResult(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> error() {
        return createResult(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMessage(), null);
    }

    public static <T> CommonResult<T> error(ResponseCode responseCode) {
        return createResult(responseCode.getCode(), responseCode.getMessage(), null);
    }

    public static <T> CommonResult<T> error(T t) {
        return createResult(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMessage(),t);
    }

    public static <T> CommonResult<T> error(ResponseCode responseCode, T data) {
        return createResult(responseCode.getCode(), responseCode.getMessage(), data);
    }

    public static <T> CommonResult<T> error(ResponseCode responseCode, String message) {
        return createResult(responseCode.getCode(),
                String.format("%s %s", responseCode.getMessage(), message), null);
    }

    public static <T> CommonResult<T> error(Integer code, String message) {
        return createResult(code, message, null);
    }

    private static <T> CommonResult<T> createResult(Integer code, String message, T data) {
        CommonResult<T> r = new CommonResult<>();
        r.setCode(code);
        r.setMessage(message);
        r.setData(data);
        return r;
    }


    @Getter
    @AllArgsConstructor
    public enum  ResponseCode{

        SUCCESS(200, "成功"),
        FAIL(400, "失败");

        final Integer code;
        final String message;

    }

}
