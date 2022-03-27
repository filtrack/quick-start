package com.app.service.impl;

import com.app.domain.entity.User;
import com.app.mapper.UserMapper;
import com.app.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Admin
 * @description 针对表【users】的数据库操作Service实现
 * @createDate 2022-03-24 09:05:05
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper usersMapper;

    @Override
    public PageInfo<User> fetchPage(User page) {
        PageInfo<User> pageInfo = PageHelper.startPage(1, 2).doSelectPageInfo(() -> usersMapper.getUsers());
        return pageInfo;
    }
}




