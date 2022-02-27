package com.app.api;

import com.app.comp.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ApiAppTests {

    @Autowired
    RedisService redisService;

    @Test
    void testRedis(){

        System.out.println(new Date());
        String key = "houjingwei_key_";
        String val = "curl -X POST ";
        int num = 1000;
        for(int i = 0;i<num;i++){
            redisService.set(key+i,val+i,6);
        }
        System.out.println(new Date());
    }

}
