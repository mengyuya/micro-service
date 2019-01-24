package com.asus.usercenter.common.enums;

public enum ResponseCode {

/*    DEFINE("默认", 0),
    SUCCEED("成功", 1),
    FAILED("失败", 2),
    ARGUMENTS_EXCEPTION("参数异常", 100),
    DATA_EXIST("数据已存在", 101),
    DATA_EXCEPTION("数据异常", 102),
    LOGIN_EXCEPTION("登录异常", 200),
    NOT_LOGIN("未登录", 201),
    RE_LOGIN("请重新登录", 202),
    USER_NOT_FOUND("未找到相应用户", 203),
    USER_PASSWORD_ERROR("密码错误", 204),
    USER_NOT_ACCESS("没有权限", 205),
    PHONE_EXIST("手机号码已存在", 206),
    EMAIL_EXIST("邮箱已存在", 207),
    LOGIN_NAME_EXIST("登录名已存在", 208);*/

    DEFINE("DEFINE", 0),
    SUCCEED("SUCCEED", 1),
    FAILED("FAILED", 2),
    EXCEPTION("EXCEPTION", 3),
    ARGUMENTS_EXCEPTION("ARGUMENTS_EXCEPTION", 100),
    DATA_EXIST("DATA_EXIST", 101),
    DATA_EXCEPTION("DATA_EXCEPTION", 102),
    LOGIN_EXCEPTION("LOGIN_EXCEPTION", 200),
    NOT_LOGIN("NOT_LOGIN", 201),
    RE_LOGIN("RE_LOGIN", 202),
    USER_NOT_FOUND("USER_NOT_FOUND", 203),
    USER_PASSWORD_ERROR("USER_PASSWORD_ERROR", 204),
    USER_NOT_ACCESS("USER_NOT_ACCESS", 205),
    PHONE_EXIST("PHONE_EXIST", 206),
    EMAIL_EXIST("EMAIL_EXIST", 207),
    LOGIN_NAME_EXIST("LOGIN_NAME_EXIST", 208);

    //中文名称
    private String message;
    //编码
    private int code;

    private ResponseCode(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public static ResponseCode getEnum(int code) {
        for (ResponseCode emu : ResponseCode.values()) {
            if (emu.code == code) {
                return emu;
            }
        }
        return null;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
