package com.asus.usercenter.controller;

import com.asus.usercenter.common.bean.ResultInfo;
import com.asus.usercenter.common.constants.MsgConstants;
import com.asus.usercenter.dao.domain.UserInfo;
import com.asus.usercenter.service.UserManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("会员服务接口")
public class UserManageController extends BaseController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    UserManageService userManageService;

    @ApiOperation("删除")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataType = "String")
    @PostMapping("/delete")
    public ResultInfo deleteByPrimaryKey(Integer id) throws Exception {

        return success(MsgConstants.DELETE_SUCCESS_MSG, userManageService.deleteByPrimaryKey(id));
    }

    @ApiOperation("新增")
    @ApiImplicitParam(name = "record", value = "用户信息", required = true)
    @PostMapping("/insert")
    public ResultInfo insert(@RequestBody UserInfo record) throws Exception {
        return success(MsgConstants.INSERT_SUCCESS_MSG, userManageService.insert(record));
    }

    @ApiOperation("查询详细")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataType = "String")
    @GetMapping("/queryOne")
    public ResultInfo selectByPrimaryKey(Integer id) throws Exception {
        return success(MsgConstants.QUERY_SUCCESS_MSG, userManageService.selectByPrimaryKey(id));
    }

    @ApiOperation("查询列表")
    @GetMapping("/queryList")
    public ResultInfo selectAll() throws Exception {
        //throw new RuntimeException("测试Hystrix的fallback异常！");

        return success(MsgConstants.QUERY_SUCCESS_MSG, userManageService.selectAll());
    }

    @ApiOperation("修改")
    @ApiImplicitParam(name = "record", value = "用户信息", required = true, dataTypeClass = UserInfo.class)
    @PostMapping("/update")
    public ResultInfo updateByPrimaryKey(@RequestBody UserInfo record) throws Exception {
        return success(MsgConstants.UPFATE_SUCCESS_MSG, userManageService.updateByPrimaryKey(record));
    }
}
