package com.spring.vongrabbitmq.service;

import com.spring.vongrabbitmq.entity.vUser;

public interface VUserService {
    public vUser getByUserName(String username);
    public String getClientId(String username, String password);
}
