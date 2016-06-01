package com.zhuyy.demo.util.vo;

/**
 * Created by duming on 2016/3/31.
 */
public class RspSuccessVo {

    private String code;
    private Object obj;

    public RspSuccessVo(String code, Object obj) {
        this.code = code;
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
