package com.asus.orderservice.feign;

import com.asus.orderservice.common.bean.ResultInfo;
import com.asus.orderservice.fallback.UserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-service", fallback = UserFallback.class)
public interface UserFeign {

    /**
     * 查询用户中心列表
     *
     * @return
     */
    //@GetMapping("/user/queryList")
    @GetMapping("/queryList")
    ResultInfo selectAll();

}
