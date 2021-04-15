package com.spring.vongrabbitmq.controller;

import com.spring.vongrabbitmq.response.MyToken;
import com.spring.vongrabbitmq.entity.oauthClientDetails;
import com.spring.vongrabbitmq.entity.vUser;
import com.spring.vongrabbitmq.service.impl.MyClientDetailsServiceImpl;
import com.spring.vongrabbitmq.service.impl.VUserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@CrossOrigin
@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    VUserServiceImpl userService;
    @Resource
    MyClientDetailsServiceImpl myClientDetailsService;

    @PreAuthorize("hasAuthority('VONG_IMG')") // super是我们在MyUserDetailsService中赋予admin用户的。
    @GetMapping("apply")
    public String applyOrder(){
        return "图片相册权限";
    }

    @PreAuthorize("hasAuthority('VONG_MUSIC')")
    @GetMapping("apply2")
    public String applyOrder2(){
        return "免费听歌权限";
    }

    @RequestMapping("/pass")
    public MyToken getPassToken(@RequestParam String username, @RequestParam String password) throws UserPrincipalNotFoundException {
        //String clientId = userService.getClientId(username, new BCryptPasswordEncoder().encode("vue"));
        vUser users = userService.getByUserName(username);
        if(users==null) throw new UserPrincipalNotFoundException("找不到该用户");
        oauthClientDetails allByClientId = myClientDetailsService.getAllByClientId(users.getClientId());
        String clientId = users.getClientId();
        String clientSecret = "sec";
        String host = "http://localhost:8081/";
        String type = "client_credentials";
        return new RestTemplate()
            .getForObject(host + "oauth/token?grant_type=" + type + "&client_id=" + clientId + "&client_secret=" + clientSecret + "&scopes=app",
                          MyToken.class);
    }

    //获取token请访问 http://localhost:8081/oauth/authorize?client_id=client&response_type=code
    @CrossOrigin
    @RequestMapping("/dc")
    public MyToken getCodesToken(@RequestParam String code) throws UserPrincipalNotFoundException {
        String clientId = "client";
        String clientSecret = "secret";
        String host = "http://localhost:8081/";
        String type = "authorization_code";
        String codes = code;
        return new RestTemplate()
                .getForObject(host + "oauth/token?grant_type=" + type +"&code=" + codes +"&client_id=" + clientId + "&client_secret=" + clientSecret + "&scopes=app",
                        MyToken.class);
    }
}
