package com.asus.usercenter.serviceImpl;

import com.asus.usercenter.dao.domain.UserInfo;
import com.asus.usercenter.dao.mapper.UserInfoMapper;
import com.asus.usercenter.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public int deleteByPrimaryKey(Integer id) throws Exception {
        return userInfoMapper.deleteByPrimaryKey(new BigDecimal(id));
    }

    public int insert(@RequestBody UserInfo record) throws Exception {
        return userInfoMapper.insert(record);
    }

    public UserInfo selectByPrimaryKey(Integer id) throws Exception {
        return userInfoMapper.selectByPrimaryKey(new BigDecimal(id));
    }

    public List<UserInfo> selectAll() throws Exception {
        return userInfoMapper.selectAll();
    }

    public int updateByPrimaryKey(@RequestBody UserInfo record) throws Exception {
        return userInfoMapper.updateByPrimaryKey(record);
    }

}
