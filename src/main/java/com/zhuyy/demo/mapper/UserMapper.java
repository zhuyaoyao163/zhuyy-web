package com.zhuyy.demo.mapper;

import com.zhuyy.demo.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserForLogin(@Param("loginName") String loginName,@Param("passWord") String passWord);
}