package com.zhuyy.demo.mapper;

import com.zhuyy.demo.model.Employee;

public interface EmployeeMapper {
    int insert(Employee record);

    int insertSelective(Employee record);
}