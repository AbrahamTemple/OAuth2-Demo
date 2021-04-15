package com.spring.vongrabbitmq.service;


import com.spring.vongrabbitmq.entity.oauthClientDetails;

public interface MyClientDetailsService {
    public oauthClientDetails getAllByClientId(String clientId);
}
