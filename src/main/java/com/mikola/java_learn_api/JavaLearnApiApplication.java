package com.mikola.java_learn_api;

import com.mikola.java_learn_api.client.GigaChatClient;
import com.mikola.java_learn_api.dto.TaskDto;
import com.mikola.java_learn_api.request.ChatCompletionRequest;
import com.mikola.java_learn_api.service.GigaChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@Component
@RequiredArgsConstructor
public class JavaLearnApiApplication {

   // private final GigaChatClient client;

//    public static void main(String[] args) {
//        SpringApplication.run(JavaLearnApiApplication.class, args);
//    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
//        System.setProperty("javax.net.ssl.trustStore","app.keystore");
//        System.setProperty("javax.net.ssl.trustStorePassword","abcd123");
        GigaChatClient gigaChatClient = new GigaChatClient(new ChatCompletionRequest(), new GigaChatService());
        System.out.println(gigaChatClient.makeRequest(new TaskDto()));
    }
}
