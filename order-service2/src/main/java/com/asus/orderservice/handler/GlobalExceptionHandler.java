package com.asus.orderservice.handler;

import com.asus.orderservice.common.enums.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = "com.asus.usercenter.controller")
class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("=====【异常】======请求" + req.getRequestURL() + "发生异常:==============");
        e.printStackTrace();

        //TODO 将异常日志入库（MongoBD）
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        mav.addObject("code", ResponseCode.EXCEPTION.getCode());
        mav.addObject("msg", "系统异常！");
        mav.addObject("url", req.getRequestURL());
        mav.addObject("exception", e);
        return mav;
    }


}
