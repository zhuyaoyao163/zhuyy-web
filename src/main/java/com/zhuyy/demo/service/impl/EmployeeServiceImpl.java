package com.zhuyy.demo.service.impl;

import com.zhuyy.demo.mapper.EmployeeMapper;
import com.zhuyy.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/5/31.
 */

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public boolean login(String loginName, String passWord, String validCode) {
        return false;
    }
}
