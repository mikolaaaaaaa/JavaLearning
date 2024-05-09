package com.mikola.java_learn_api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class JavaLearnApiApplication {

    //private final GigaChatClient client;


    public static void main(String[] args) {
        SpringApplication.run(JavaLearnApiApplication.class, args);
    }

//    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
////        System.setProperty("javax.net.ssl.trustStore","app.keystore");
////        System.setProperty("javax.net.ssl.trustStorePassword","abcd123");
//        System.out.println(.makeRequest(new TaskDto()));
//    }
}
