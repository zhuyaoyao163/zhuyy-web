package com.zhuyy.demo.vo;

/**
 * Created by Administrator on 2016/5/31.
 */
public class LoginReqVo {
    public String userName;
    public String passWord;
    public String validCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }
}
