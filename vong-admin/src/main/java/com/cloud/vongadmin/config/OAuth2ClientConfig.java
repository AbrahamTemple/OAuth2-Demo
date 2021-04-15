package com.cloud.vongadmin.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

//@Configuration
//@EnableOAuth2Client
//public class OAuth2ClientConfig {
//
//    //创建token认证远程调用http模板
//    @Bean
//    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext context, OAuth2ProtectedResourceDetails details) {
//
//        AuthorizationCodeAccessTokenProvider authCodeProvider = new AuthorizationCodeAccessTokenProvider();
//        authCodeProvider.setStateMandatory(false);
//
//        AccessTokenProviderChain provider = new AccessTokenProviderChain(Arrays.asList(authCodeProvider));
//
//        OAuth2RestTemplate template = new OAuth2RestTemplate(details, context);
//        template.setAccessTokenProvider(provider);
//
//        return template;
//    }
//
//    //注册处理redirect uri的filter,拦截redirectUri,根据授权服务器返回的授权码code获取token
//    @Bean
//    public OAuth2ClientAuthenticationProcessingFilter oauth2ClientAuthenticationProcessingFilter(
//            OAuth2RestTemplate oauth2RestTemplate, RemoteTokenServices tokenService) {
//
//        // 创建重定向URL过滤器
//        OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter("/login");
//        // 设置token远程调用接口
//        filter.setTokenServices(tokenService);
//        // 设置远程调用使用的模板
//        filter.setRestTemplate(oauth2RestTemplate);
//        // 设置回调成功的页面
//        filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler() {
//            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                                Authentication authentication) throws IOException, ServletException {
//                // 认证成功之后返回的主页
//                this.setDefaultTargetUrl("/");
//                super.onAuthenticationSuccess(request, response, authentication);
//            }
//        });
//        return filter;
//    }
//
//    //注册token检查服务-从远程授权服务获取用户认证信息
//    @Bean
//    @Primary
//    public RemoteTokenServices tokenService(OAuth2ProtectedResourceDetails details) {
//        RemoteTokenServices tokenService = new RemoteTokenServices();
//        tokenService.setCheckTokenEndpointUrl("http://127.0.0.1:8086/oauth/check_token");
//        tokenService.setClientId(details.getClientId());
//        tokenService.setClientSecret(details.getClientSecret());
//        return tokenService;
//    }
//
//    @Bean
//    @ConfigurationProperties("security.oauth2.client")
//    public AuthorizationCodeResourceDetails google() {
//        return new AuthorizationCodeResourceDetails();
//    }
////
////    @Bean
////    @ConfigurationProperties("security.oauth2.resource")
////    public ResourceServerProperties googleResource() {
////        return new ResourceServerProperties();
////    }
//
//}
