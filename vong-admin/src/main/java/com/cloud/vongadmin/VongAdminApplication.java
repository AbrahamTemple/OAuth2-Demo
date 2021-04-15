package com.cloud.vongadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cloud.vongadmin.mapper")
public class VongAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(VongAdminApplication.class, args);
    }

}
