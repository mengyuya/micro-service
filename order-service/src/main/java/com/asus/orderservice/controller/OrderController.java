package com.asus.orderservice.controller;

import com.asus.orderservice.common.bean.ResultInfo;
import com.asus.orderservice.common.constants.MsgConstants;
import com.asus.orderservice.feign.UserFeign;
import com.asus.orderservice.service.OrderManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api("订单服务接口")
public class OrderController extends BaseController {

    @Resource
    UserFeign userFeign;

    @Autowired
    OrderManageService orderManageService;

    @ApiOperation("查询订单+会员")
    @GetMapping("/queryOrderAndUserList")
    public ResultInfo queryOrderAndUserList() throws Exception {
        //throw new Exception("AAAAAAAAAAAAAAAAAAAA");
        ResultInfo resultInfo = userFeign.selectAll();
        String order = orderManageService.selectAll();
        resultInfo.setData(resultInfo.getData() + order);

        return success(MsgConstants.QUERY_SUCCESS_MSG, resultInfo);
    }
}
