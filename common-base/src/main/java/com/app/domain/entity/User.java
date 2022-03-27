package com.app.domain.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title
 * @Auther hjw
 * @Date 2022/3/25 11:03
 * @Version 1.0
 */
@Data
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -7469523221394439601L;

    private String userName;
    private String nickName;
    private Integer age;
    private Integer sex;
    private String phone;
    private String email;

}
