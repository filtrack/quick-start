package com.app.service;

import com.app.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
* @author Admin
* @description 针对表【users】的数据库操作Service
* @createDate 2022-03-24 09:05:05
*/
public interface UserService extends IService<User> {

    PageInfo fetchPage(User user);
}
