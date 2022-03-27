package com.app.controller;

import com.app.domain.entity.User;
import com.app.result.PageResult;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title
 * @Auther hjw
 * @Date 2022/3/24 9:07
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    UserService usersService;

    @GetMapping("/test1")
    public PageResult test(){
        User user = new User();
        return PageResult.success(usersService.fetchPage(user));
    }

    @GetMapping("/addUser")
    public PageResult save(){
        User user = new User();
        user.setNickName("wolegeq");
        user.setSex(0);
        user.setPhone("18823701350");
        user.setAge(22);
        user.setUserName("HouJingWei");
        usersService.save(user);
        return PageResult.success();
    }
}
