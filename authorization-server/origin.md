# OAuth2使用RestTemplate请求token
这是我第一次提交的OAuth认证服务器项目

即使内容有些粗劣

但保留它归因初始想法

那就是更易于理解

v_user表加密密码:
  - vue : vue
  - admin : admin

oauth_client_details表加密密码:
  - cli : sec
  - client : secret
  - clients : secrets

项目引用了mybatis plus，请记得entity的实体类与表同名。

主要的代码在authorization-server认证服务器项目下的控制类内:

    @RequestMapping("/pass")
    public MyToken getPassToken(@RequestParam String username, @RequestParam String password) throws UserPrincipalNotFoundException {
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