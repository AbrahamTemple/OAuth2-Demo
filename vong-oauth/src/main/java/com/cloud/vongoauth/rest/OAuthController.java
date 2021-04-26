package com.cloud.vongoauth.rest;

import com.cloud.vongoauth.domain.CodeGrantInfo;
import com.cloud.vongoauth.domain.CodeInfo;
import com.cloud.vongoauth.domain.CredentialsGrantInfo;
import com.cloud.vongoauth.entity.vUser;
import com.cloud.vongoauth.dto.MyTokenDto;
import com.cloud.vongoauth.service.VUserService;
import com.cloud.vongoauth.service.impl.MyClientDetailsServiceImpl;
import com.cloud.vongoauth.vo.OAuthGrantInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * 主认证控制类
 */
@CrossOrigin
@RestController
@RequestMapping("/o")
public class OAuthController {

    @Resource
    VUserService userService;
    @Resource
    MyClientDetailsServiceImpl myClientDetailsService;

    protected OAuthGrantInfo instance;

    /**
     * 密码模式请求token
     * @param username
     * @param password
     * @return
     * @throws UserPrincipalNotFoundException
     */
    @RequestMapping("/pass")
    public MyTokenDto getPassToken(@RequestParam String username, @RequestParam String password) throws UserPrincipalNotFoundException {

//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        try {
//            subject.login(token);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        instance = CredentialsGrantInfo.getInstance();
        return new RestTemplate().getForObject(instance.toString(), MyTokenDto.class);
    }

    /**
     * 授权码模式请求token
     * 获取token请访问 http://localhost:8077/oauth/authorize?client_id=client&response_type=code
     * @param code
     * @return
     */
    @RequestMapping("/code")
    public MyTokenDto getCodesToken(@RequestParam String code){
        instance = CodeGrantInfo.getInstance();
        instance.setCodes(code);
        return new RestTemplate().getForObject(instance.toString(), MyTokenDto.class);
    }

    /**
     * 请求code
     * @return
     */
    @RequestMapping("/code/get")
    public MyTokenDto getCodes(){
        instance = CodeInfo.getInstance();
        return new RestTemplate().getForObject(instance.toString(), MyTokenDto.class);
    }


//    @PreAuthorize("hasAuthority('VONG_IMG')")
//    @GetMapping("apply")
//    public String applyOrder(){
//        return "图片相册权限";
//    }
//
//    @PreAuthorize("hasAuthority('VONG_MUSIC')")
//    @GetMapping("apply2")
//    public String applyOrder2(){
//        return "免费听歌权限";
//    }
}
