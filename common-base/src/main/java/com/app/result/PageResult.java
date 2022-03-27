package com.app.result;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {

    //返回码
    private Integer code;
    //返回信息
    private String message;

    //结果集
    private int pageNum;
    private int pageSize;
    private int pages;
    private long total;

    private List<T> data;

    public static <T> PageResult<T> success() {
        return createResult(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static <T> PageResult<T> success(List<T> data) {
        return createResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> PageResult<T> success(String message) {
        return createResult(ResponseCode.SUCCESS.getCode(), message, null);
    }

    public static <T> PageResult<T> success(List<T> data, String message) {
        return createResult(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> PageResult<T> error() {
        return createResult(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMessage(), null);
    }

    public static <T> PageResult<T> error(ResponseCode responseCode) {
        return createResult(responseCode.getCode(), responseCode.getMessage(), null);
    }


    public static <T> PageResult<T> error(ResponseCode responseCode, String message) {
        return createResult(responseCode.getCode(),
                String.format("%s %s", responseCode.getMessage(), message), null);
    }

    public static <T> PageResult<T> error(Integer code, String message) {
        return createResult(code, message, null);
    }

    private static <T> PageResult<T> createResult(Integer code, String message, List<T> data) {
        PageResult<T> r = new PageResult<>();
        r.setCode(code);
        r.setMessage(message);
//        r.setData(data);
        return r;
    }

    public static PageResult success(PageInfo pageInfo) {
        PageResult r = new PageResult<>();
        r.setCode(PageResult.ResponseCode.SUCCESS.getCode());
        r.setData(pageInfo.getList());
        r.setPages(pageInfo.getPages());
        r.setPageNum(pageInfo.getPageNum());
        r.setPageSize(pageInfo.getPageSize());
        r.setTotal(pageInfo.getTotal());
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
