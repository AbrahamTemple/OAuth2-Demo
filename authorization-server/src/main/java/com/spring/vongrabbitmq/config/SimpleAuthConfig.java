package com.spring.vongrabbitmq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

//@Configuration
//@EnableAuthorizationServer
//public class SimpleAuthConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        //配置网关服务的用户名密码，仅网关服务可作为客户端可访问oauth服务
//        clients
//                .inMemory()
//                .withClient("client")
//                .secret(new BCryptPasswordEncoder().encode("secret"))
//                .authorizedGrantTypes("authorization_code")//授权码模式
//                .scopes("app") //应用的类型
//                .autoApprove(true) //自动审批，不用二次确认
//                .accessTokenValiditySeconds(3600) //有效期1hour
//                .redirectUris("https://localhost:8081/order/c");//code映射路径
//    }
//
//
//}
