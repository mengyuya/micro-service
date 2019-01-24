package com.asus.usercenter.common.bean;

import com.asus.usercenter.common.constants.MsgConstants;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class ResultInfo implements Serializable {
    private static final long serialVersionUID = -1418031281886709162L;
    private Integer code;        //返回状态码
    private String msg = MsgConstants.OPERATE_SUCCESS_MSG;         //返回信息
    private Object data;       //返回结果
    private Integer total;       //总条数

    public ResultInfo() {

    }

    public ResultInfo(Integer code, String msg, Object data, Integer total) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;

    }

}
