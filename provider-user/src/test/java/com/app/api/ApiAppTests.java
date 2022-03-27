package com.app.api;

import com.app.domain.entity.User;
import com.app.service.RedisService;
import com.app.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ApiAppTests {

    @Autowired
    RedisService redisService;

    @Autowired
    UserService usersService;

    @Test
    void testRedis(){
        System.out.println(new Date());
        String key = "houjingwei_key_";
        String val = "curl -X POST ";
        int num = 1000;
        for(int i = 0;i<num;i++){
            redisService.set(key+i,val+i,60);
        }
        System.out.println(new Date());
    }

    @Test
    void users(){
        System.out.println(usersService.fetchPage(new User()).toString());
    }

}
