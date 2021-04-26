# OAuth2使用RestTemplate请求token
在第一次提交的authorization-server基础上锦上添花

如果你不想看简单化的的代码请直接索引项目vong-oauth

## 以下是数据库数据的备注

v_user表加密密码:

> vue : vue

> admin : admin


oauth_client_details表加密密码:
 
> cli : sec
 
> client : secret
 
> clients : secrets


## 主要的代码在rest的控制类内:

- 密码模式认证

``` java
    @RequestMapping("/pass")
    public MyTokenDto getPassToken(@RequestParam String username, @RequestParam String password) throws UserPrincipalNotFoundException {
        instance = CredentialsGrantInfo.getInstance();
        return new RestTemplate().getForObject(instance.toString(), MyTokenDto.class);
    }
```

- 授权码模式认证

``` java
    @RequestMapping("/code")
    public MyTokenDto getCodesToken(@RequestParam String code){
        instance = CodeGrantInfo.getInstance();
        instance.setCodes(code);
        return new RestTemplate().getForObject(instance.toString(), MyTokenDto.class);
    }

    @RequestMapping("/code/get")
    public MyTokenDto getCodes(){
        instance = CodeInfo.getInstance();
        return new RestTemplate().getForObject(instance.toString(), MyTokenDto.class);
    }
```
