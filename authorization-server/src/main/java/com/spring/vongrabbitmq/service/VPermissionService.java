package com.spring.vongrabbitmq.service;

import com.spring.vongrabbitmq.entity.vPermission;

import java.util.List;

public interface VPermissionService {
    public List<vPermission> selectByUserId(Long id);
}
