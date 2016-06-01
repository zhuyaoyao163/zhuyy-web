package com.zhuyy.demo.util.vo;

/**
 * Created by duming on 2016/3/31.
 */
public class RspErrorVo {

    private String code;
    private String msg;

    public RspErrorVo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
