package com.asus.orderservice.fallback;

import com.asus.orderservice.common.bean.ResultInfo;
import com.asus.orderservice.controller.BaseController;
import com.asus.orderservice.feign.UserFeign;
import org.springframework.stereotype.Component;

@Component
public class UserFallback extends BaseController implements UserFeign {

    /**
     * 服务降级友好提示
     * 推荐此方法
     *
     * @return
     */
    @Override
    public ResultInfo selectAll() {
        return getFriendlyMsg();
    }

    private ResultInfo getFriendlyMsg() {
        return fail("总控友好提示");
    }
}
