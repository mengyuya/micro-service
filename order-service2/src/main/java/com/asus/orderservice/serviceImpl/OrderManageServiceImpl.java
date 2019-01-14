package com.asus.orderservice.serviceImpl;

import com.asus.orderservice.service.OrderManageService;
import org.springframework.stereotype.Service;

//@Transactional(rollbackFor = Exception.class)
@Service
public class OrderManageServiceImpl implements OrderManageService {


    @Override
    public String selectAll() throws Exception {
        return "这是订单服务";
    }
}
