package com.app.config;

import com.app.utils.SnowIdUtils;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * @Title
 * @Auther hjw
 * @Date 2022/3/27 16:04
 * @Version 1.0
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        //根据bizKey调用分布式ID生成
        long id = SnowIdUtils.uniqueLong();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> id "+id);
        //返回生成的id值即可.
        return id;
    }

}