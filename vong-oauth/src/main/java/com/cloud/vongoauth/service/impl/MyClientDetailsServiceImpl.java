package com.cloud.vongoauth.service.impl;

import com.cloud.vongoauth.entity.oauthClientDetails;
import com.cloud.vongoauth.mapper.ClientDetailsMapper;
import com.cloud.vongoauth.service.MyClientDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.1
 * @GitHub https://github.com/AbrahamTemple/
 * @description: OAuth客户表业务
 */
@Service
public class MyClientDetailsServiceImpl implements MyClientDetailsService {

    @Resource
    private ClientDetailsMapper clientDetailsMapper;

    @Override
    public oauthClientDetails getAllByClientId(String clientId) {
        return clientDetailsMapper.selectById(clientId);
    }
}
