package com.asus.usercenter.controller;

import com.asus.usercenter.common.bean.ResultInfo;
import com.asus.usercenter.common.constants.MsgConstants;
import com.asus.usercenter.common.enums.ResponseCode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class BaseController {

    /**
     * 列表通用返回
     *
     * @return
     */
    public static ResultInfo setList(Integer code, String msg, Object data, Integer total) {
        return new ResultInfo(code, msg, data, total);
    }

    /**
     * 通用返回
     *
     * @return
     */
    public static ResultInfo setResult(Integer code, String msg, Object data) {
        return new ResultInfo(code, msg, data, null);
    }

    /**
     * 操作成功
     *
     * @return
     */
    public static ResultInfo success() {

        return setResult(ResponseCode.SUCCEED.getCode(), MsgConstants.OPERATE_SUCCESS_MSG, null);

    }

    /**
     * 操作成功
     *
     * @return
     */
    public static ResultInfo success(String msg) {

        return setResult(ResponseCode.SUCCEED.getCode(), msg, null);
    }

    /**
     * 操作成功
     *
     * @return
     */
    public static ResultInfo success(String msg, Object data) {

        return setResult(ResponseCode.SUCCEED.getCode(), msg, data);

    }

    /**
     * 操作成功
     *
     * @return
     */
    public static ResultInfo success(String msg, Object data, Integer total) {

        return setList(ResponseCode.SUCCEED.getCode(), msg, data, total);

    }

    /**
     * 操作失败
     *
     * @return
     */
    public static ResultInfo fail() {

        return setResult(ResponseCode.FAILED.getCode(), MsgConstants.OPERATE_FAIL_MSG, null);

    }

    /**
     * 操作失败
     *
     * @return
     */
    public static ResultInfo fail(String msg) {

        return setResult(ResponseCode.FAILED.getCode(), msg, null);
    }

    /**
     * 操作异常
     *
     * @param data 错误信息
     */
    public static ResultInfo exception(Object data) {

        return setResult(ResponseCode.EXCEPTION.getCode(), MsgConstants.OPERATE_EXCEPTION_MSG, data);

    }


    /**
     * MODEL AND REVIEW
     */
    /**
     * 操作成功
     *
     * @return
     */
    public static ModelAndView successModelAndView(String path) {

        return errorModelAndView(path, ResponseCode.SUCCEED.getCode());

    }

    /**
     * 操作成功
     *
     * @return
     */
    public static ModelAndView successModelAndView(String path, String msg, Object data) {

        return errorModelAndView(path, ResponseCode.SUCCEED.getCode(), msg, data);

    }

    /**
     * 操作成功
     *
     * @return
     */
    public static ModelAndView successModelAndView(String path, String msg) {

        return errorModelAndView(path, ResponseCode.SUCCEED.getCode(), msg);

    }

    /**
     * 操作异常
     *
     * @return
     */
    public static ModelAndView errorModelAndView(String path, Integer code, String msg, Object data) {
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("code", code);
        mv.addObject("msg", msg);
        mv.addObject("data", data);
        return mv;
    }

    /**
     * 操作异常
     *
     * @return
     */
    public static ModelAndView errorModelAndView(String path, Integer code, String msg) {
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("code", code);
        mv.addObject("msg", msg);
        return mv;
    }

    /**
     * 操作异常
     *
     * @return
     */
    public static ModelAndView errorModelAndView(String path, Integer code) {
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("code", code);
        return mv;
    }

    /**
     * 操作成功
     *
     * @return
     */
    public static ModelAndView failModelAndView(String path, String msg, Object data) {

        return errorModelAndView(path, ResponseCode.FAILED.getCode(), msg, data);

    }

    /**
     * 操作失败
     *
     * @return
     */
    public static ModelAndView failModelAndView(String path, String msg) {
        return errorModelAndView(path, ResponseCode.FAILED.getCode(), msg);
    }


}
