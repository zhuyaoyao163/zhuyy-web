package com.zhuyy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/5/30.
 */
@Controller
public class LoginController {

    @RequestMapping("/index")
    public String index(){
        return "/common/login";
    }

    public String login(){

        return "";
    }
}
