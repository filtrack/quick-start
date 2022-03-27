package com.app.domain.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title
 * @Auther hjw
 * @Date 2022/3/27 10:25
 * @Version 1.0
 */
@Data
public class BaseEntity implements Serializable {


    private static final long serialVersionUID = 6947059153033883058L;

    private String id;
    private String createTime;
    private String deleteFlag;

}
