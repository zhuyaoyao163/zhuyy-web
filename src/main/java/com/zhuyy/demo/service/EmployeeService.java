package com.zhuyy.demo.service;

/**
 * Created by Administrator on 2016/5/31.
 */
public interface EmployeeService {

    /**
     * 登录
     * @param loginName 用户名
     * @param passWord 密码
     * @param validCode 验证码
     * @return
     */
    public boolean login(String loginName,String passWord,String validCode);
}
