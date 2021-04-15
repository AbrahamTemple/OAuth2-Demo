package com.spring.vongrabbitmq.service.impl;

import com.spring.vongrabbitmq.entity.oauthClientDetails;
import com.spring.vongrabbitmq.mapper.ClientDetailsMapper;
import com.spring.vongrabbitmq.service.MyClientDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyClientDetailsServiceImpl implements MyClientDetailsService {

    @Resource
    private ClientDetailsMapper clientDetailsMapper;

    @Override
    public oauthClientDetails getAllByClientId(String clientId) {
        return clientDetailsMapper.selectById(clientId);
    }
}
