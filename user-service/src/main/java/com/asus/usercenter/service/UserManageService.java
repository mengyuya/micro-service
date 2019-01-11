package com.asus.usercenter.service;

import com.asus.usercenter.dao.domain.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface UserManageService {

    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(UserInfo record) throws Exception;

    UserInfo selectByPrimaryKey(Integer id) throws Exception;

    List<UserInfo> selectAll() throws Exception;

    int updateByPrimaryKey(UserInfo record) throws Exception;
}


