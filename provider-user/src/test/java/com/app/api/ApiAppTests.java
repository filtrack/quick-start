package com.app.api;

import com.alibaba.fastjson.JSON;
import com.app.domain.entity.User;
import com.app.result.PageResult;
import com.app.service.RedisService;
import com.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@Slf4j
class ApiAppTests {

    @Autowired
    RedisService redisService;

    @Autowired
    UserService usersService;

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @Test
    void testRedis(){
        System.out.println(new Date());
        String key = "houjingwei_key_";
        String val = "curl -X POST ";
        int num = 100;
        for(int i = 0;i<num;i++){
            redisService.set(key+i,val+i,60);
        }
        System.out.println(new Date());
    }

    @Test
    void users(){
       PageResult pageResult =  PageResult.success(usersService.fetchPage(new User()));
        System.out.println(JSON.toJSONString(pageResult));
    }

}
