package com.yry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
//@Configuration
//@SpringBootApplication(scanBasePackages = {"com.yry"})
@SpringBootApplication
//@EnableFeignClients(basePackages = {"com.yry.clients"})
//@EnableDiscoveryClient

public class RoleService {
    public static void main(String[] args) {
        SpringApplication.run(RoleService.class, args);
    }
}
