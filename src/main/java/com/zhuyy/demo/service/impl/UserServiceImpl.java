package com.zhuyy.demo.service.impl;

import com.zhuyy.demo.mapper.UserMapper;
import com.zhuyy.demo.model.User;
import com.zhuyy.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/5/31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(String loginName, String passWord, String validCode) {

        User user = userMapper.selectUserForLogin(loginName, passWord);
        if (user != null) {
            return true;
        }
        return false;
    }
}
