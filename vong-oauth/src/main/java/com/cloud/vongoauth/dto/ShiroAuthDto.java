package com.cloud.vongoauth.dto;

import com.cloud.vongoauth.entity.vUser;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
//import org.apache.shiro.util.ByteSource;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.26
 * @GitHub https://github.com/AbrahamTemple/
 * @description: Shiro认证对象
 */

@Data
@RequiredArgsConstructor
public class ShiroAuthDto {

    @NonNull
    private vUser principal;
    @NonNull
    private String encryptionCode;
    @NonNull
    private String clearCode;
    @NonNull
    private String credentials;

//    private ByteSource salt;
    private String realmName;

}
