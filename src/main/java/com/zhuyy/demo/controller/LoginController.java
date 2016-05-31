package com.zhuyy.demo.controller;

import com.zhuyy.demo.service.EmployeeService;
import com.zhuyy.demo.service.UserService;
import com.zhuyy.demo.vo.LoginReqVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/5/30.
 */
@Controller
public class LoginController {

    private Logger LOGGER = Logger.getLogger(LoginController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "/common/login";
    }

    @RequestMapping("/login")
    public String login(LoginReqVo user, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        LOGGER.info("session中的值:"+session.getAttribute("SE_KEY_MM_CODE"));
        LOGGER.info("validCode:"+user.getValidCode());
        if(session.getAttribute("SE_KEY_MM_CODE").equals(user.getValidCode())){
            if (userService.login(user.getUserName(), user.getPassWord(), user.getValidCode())) {
                return "/common/success";
            }
        }
        return "/common/error";
    }

}
