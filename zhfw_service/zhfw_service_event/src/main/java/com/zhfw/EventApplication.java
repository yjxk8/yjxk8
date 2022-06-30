package com.zhfw;

import com.zhfw.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.zhfw.event.dao"})
public class EventApplication {


    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class);
    }

}
