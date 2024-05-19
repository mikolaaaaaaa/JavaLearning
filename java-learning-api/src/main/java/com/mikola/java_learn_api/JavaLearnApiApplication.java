package com.mikola.java_learn_api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class JavaLearnApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLearnApiApplication.class, args);
    }

}
