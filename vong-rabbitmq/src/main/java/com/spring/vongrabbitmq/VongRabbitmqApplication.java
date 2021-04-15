package com.spring.vongrabbitmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.spring.vongrabbitmq.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class VongRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(VongRabbitmqApplication.class, args);
    }

}
