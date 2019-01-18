package com.asus.usercenter.dao.mapper;

import com.asus.usercenter.dao.domain.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Repository("userInfoMapper")
public interface UserInfoMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(UserInfo record);

    UserInfo selectByPrimaryKey(BigDecimal id);

    List<UserInfo> selectAll();

    int updateByPrimaryKey(UserInfo record);
}