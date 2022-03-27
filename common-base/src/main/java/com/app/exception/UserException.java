package com.app.exception;

import lombok.Data;
import lombok.Getter;

/**
 * @Title
 * @Auther hjw
 * @Date 2022/3/25 11:19
 * @Version 1.0
 */
@Data
public class UserException  extends RuntimeException {

    private Integer code;

    /**
     * 使用枚举传参
     * @param errorCode 异常枚举
     */
    public UserException(UserErrorCode errorCode) {
        super(errorCode.getMessage());
        this.setCode(errorCode.getCode());
    }


    @Getter
    public enum UserErrorCode{

        //权限异常
        NOT_PERMISSIONS(401,"您没有操作权限"),
        ;

        private Integer code;
        private String message;

        UserErrorCode(Integer code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
