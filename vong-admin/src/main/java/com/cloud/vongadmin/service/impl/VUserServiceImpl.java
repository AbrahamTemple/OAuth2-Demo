package com.cloud.vongadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.vongadmin.entity.vUser;
import com.cloud.vongadmin.mapper.VUserMapper;
import com.cloud.vongadmin.service.VUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VUserServiceImpl implements VUserService {

    @Resource
    private VUserMapper vUserMapper;

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
