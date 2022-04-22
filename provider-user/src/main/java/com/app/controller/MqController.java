package com.app.controller;

import com.app.domain.entity.User;
import com.app.result.CommonResult;
import com.app.result.PageResult;
import com.app.service.UserService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title
 * @Auther hjw
 * @Date 2022/3/24 9:07
 * @Version 1.0
 */
@RestController
public class MqController {

    @Resource
    RocketMQTemplate rocketMQTemplate;

    @GetMapping("/msg1")
    public CommonResult msg1(){
        rocketMQTemplate.syncSend("test-topic","我就是我");
        return CommonResult.success();
    }

}
