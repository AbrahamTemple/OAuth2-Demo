package com.spring.vongrabbitmq.service.impl;

import com.spring.vongrabbitmq.entity.vPermission;
import com.spring.vongrabbitmq.mapper.VPermissionMapper;
import com.spring.vongrabbitmq.service.VPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VPermissionServiceImpl implements VPermissionService {

    @Resource
    private VPermissionMapper vPermissionMapper;

    @Override
    public List<vPermission> selectByUserId(Long id) {
        List<vPermission> vPermissions = vPermissionMapper.selectByLeftUserId(id);
        if(vPermissions.size()>0){
            return vPermissions;
        } return null;
    }
}
