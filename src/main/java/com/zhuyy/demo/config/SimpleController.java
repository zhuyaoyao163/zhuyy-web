package com.zhuyy.demo.config;

import com.zhuyy.demo.util.exception.BusinessException;
import com.zhuyy.demo.util.vo.RspErrorVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by Administrator on 2016/6/2.
 */
@ControllerAdvice
public class SimpleController {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public RspErrorVo handleBusinessException(BusinessException ex) {
        RspErrorVo rspErrorVo = new RspErrorVo(ex.getErrorCode(), ex.getMessage());
        return rspErrorVo;
    }
}
