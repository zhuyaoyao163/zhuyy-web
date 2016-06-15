package com.zhuyy.demo.service;

import com.zhuyy.demo.util.vo.RspData;
import com.zhuyy.demo.vo.LoginReqVo;

/**
 * Created by Administrator on 2016/5/31.
 */
public interface UserService {
    /**
     * 登录
     * @param loginReqVo 登录请求
     * @return
     */
    public RspData login(LoginReqVo loginReqVo);

    public void receiveMsg();
}
