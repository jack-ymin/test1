package com.sz.dingdan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.sz.dingdan.mapper")
public class UserStarter {
    public static void main(String[] args) {
        SpringApplication.run(UserStarter.class);
    }
}
