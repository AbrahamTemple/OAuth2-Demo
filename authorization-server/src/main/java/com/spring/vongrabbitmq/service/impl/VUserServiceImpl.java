package com.spring.vongrabbitmq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.vongrabbitmq.entity.vUser;
import com.spring.vongrabbitmq.mapper.VUserMapper;
import com.spring.vongrabbitmq.service.VUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VUserServiceImpl implements VUserService {

    @Resource
    private VUserMapper vUserMapper;

    @Override
    public vUser getByUserName(String username) {
        QueryWrapper<vUser> userInfo = new QueryWrapper<vUser>().eq("username", username);
        List<vUser> vUsers = vUserMapper.selectList(userInfo);
        if(vUsers.size()>0){
            return vUsers.get(0);
        } return null;
    }

    @Override
    public String getClientId(String username, String password) {
        QueryWrapper<vUser> userInfo = new QueryWrapper<vUser>()
                .eq("username", username).eq("password",password);
        List<vUser> vUsers = vUserMapper.selectList(userInfo);
        if(vUsers.size()>0){
            return vUsers.get(0).getClientId();
        } return null;
    }
}
