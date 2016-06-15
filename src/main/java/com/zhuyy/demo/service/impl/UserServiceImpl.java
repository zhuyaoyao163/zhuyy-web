package com.zhuyy.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhuyy.demo.mapper.UserMapper;
import com.zhuyy.demo.model.User;
import com.zhuyy.demo.service.UserService;
import com.zhuyy.demo.util.activemq.util.DemoMqReceiver;
import com.zhuyy.demo.util.activemq.util.DemoMqSender;
import com.zhuyy.demo.util.constant.Constant;
import com.zhuyy.demo.util.redis.RedisClientTemplate;
import com.zhuyy.demo.util.vo.RspData;
import com.zhuyy.demo.vo.LoginReqVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Set;

import static com.alibaba.fastjson.JSON.parseObject;
import static javafx.scene.input.KeyCode.L;

/**
 * Created by Administrator on 2016/5/31.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisClientTemplate redisClientTemplate;

    @Resource
    private DemoMqSender demoMqSender;

    @Resource
    private DemoMqReceiver demoMqReceiver;
    //登录需要验证码的标志
    private static final int errCode = 2;
    @Override
    public RspData login(LoginReqVo loginReqVo) {
        User user = null;
        String userStr = redisClientTemplate.get(redisClientTemplate.generateCacheKey(Constant.LOGIN_SUCCESS_USER, loginReqVo.getUserName()));
        if (userStr != null && !"".equals(userStr)) {
            user = JSON.parseObject(userStr, User.class);
        }else{
            user = userMapper.selectUserForLogin(loginReqVo.getUserName(), loginReqVo.getPassWord());
            redisClientTemplate.set(redisClientTemplate.generateCacheKey(Constant.LOGIN_SUCCESS_USER, loginReqVo.getUserName()),JSON.toJSONString(user));
        }
        return loginCheck(loginReqVo,user);
    }

    public RspData loginCheck(LoginReqVo loginReqVo, User user) {
        String keyRule = redisClientTemplate.generateCacheKey(Constant.LOGIN_FAIL_USER, loginReqVo.getUserName(), Constant.WILD_CARD);
        if (user != null) {
            if (loginReqVo.getPassWord().equals(user.getPassWord())){
                try {
                    redisClientTemplate.delByKeyRule(keyRule);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                demoMqSender.send("登录成功！");
                return RspData.success(null);
            }else{
                //登录失败用户，放入缓存，并指定过期时间
                redisClientTemplate.setex(redisClientTemplate.generateCacheKey(Constant.LOGIN_FAIL_USER, loginReqVo.getUserName(),System.currentTimeMillis()),3600,loginReqVo.getUserName());
                //查询用户在一小时内登录错误次数
                Set<String> failLoginSet = redisClientTemplate.getAllKeySet(keyRule);
                if (failLoginSet.size() >= 3){
                    //页面显示验证码
                    return RspData.error(errCode, "登录失败次数过多");
                }
            }
        }
        return RspData.error(Constant.FAIL_CODE, "密码用户不匹配");
    }

    public void receiveMsg() {
        demoMqReceiver.receiveMsg();
    }
}
