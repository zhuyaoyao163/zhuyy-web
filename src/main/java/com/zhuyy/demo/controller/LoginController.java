package com.zhuyy.demo.controller;

import com.zhuyy.demo.model.User;
import com.zhuyy.demo.service.EmployeeService;
import com.zhuyy.demo.service.UserService;
import com.zhuyy.demo.util.constant.Constant;
import com.zhuyy.demo.util.redis.RedisClientTemplate;
import com.zhuyy.demo.util.vo.RspData;
import com.zhuyy.demo.vo.LoginReqVo;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.zhuyy.demo.util.constant.Constant.FAIL_VALID_CODE;

/**
 * Created by Administrator on 2016/5/30.
 */
@Controller
public class LoginController {

    private Logger LOGGER = Logger.getLogger(LoginController.class);
    @Resource
    private UserService userService;

    /*@Resource
    private MongoTemplate mongoTemplate;*/

    @RequestMapping("/index")
    public String index(){
        return "/common/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public RspData login(LoginReqVo user, Model model, HttpServletRequest request) {
        if (user.getValidCode() != null && !"".equals(user.getValidCode())) {
            HttpSession session = request.getSession();
            if (!session.getAttribute(Constant.KEY_CAPTCHA).equals(user.getValidCode())) {
                return RspData.error(FAIL_VALID_CODE, "验证码不匹配！");
            }
        }
        RspData rspData = userService.login(user);
        if (rspData.getCode() == 0) {
            HttpSession session = request.getSession();
            session.setAttribute(user.getUserName(), user);
        }
       /* mongoTemplate.save(user);*/
        return rspData;
    }

    @RequestMapping("/success")
    public String success(){
        return "/common/success";
    }

    @RequestMapping("/fail")
    public String fail(){
        return "/common/error";
    }

    @RequestMapping("/receive")
    public String receive(){
        /*userService.receiveMsg();*/
        return "/common/success";
    }
}
