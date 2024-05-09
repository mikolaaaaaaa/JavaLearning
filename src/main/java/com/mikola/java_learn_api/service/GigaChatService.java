package com.mikola.java_learn_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikola.java_learn_api.client.AuthFeignClient;
import com.mikola.java_learn_api.client.CompletionFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class GigaChatService {

    @Value("${gigachat.clientSecret}")
    private String clientSecret;

    @Value("${gigachat.clientId}")
    private String clientId;

    @Value("${gigachat.scope}")
    private String scope;

    @Value("${gigachat.model}")
    private String model;

    private final AuthFeignClient gigaChatAuthFeignClient;
    private final CompletionFeignClient gigaChatGenFeignClient;

    public String getAccessToken() {
        String authorization = Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));
        log.info("auth data: " + authorization);
        String rqUID = UUID.randomUUID().toString();
        String body = "scope=" + scope;

        String response = gigaChatAuthFeignClient.getAccessToken("Basic " + authorization, rqUID, body);

        return response.substring(response.indexOf("access_token=") + 18, response.length() - 29);
    }

    public String getModel() {
        String token = getAccessToken();
        log.info("token: " + token);

        String response = gigaChatGenFeignClient.getModel("Bearer " + token);

        int startIndex = response.indexOf(model);
        if (startIndex != -1) {
            model = response.substring(startIndex, startIndex + model.length());
        }
        else {
            log.info("Модель устарела. Выберите новую");
        }

        return model;
    }

    public String getAnswer(String content) throws JsonProcessingException {
        String token = getAccessToken();
        String model = getModel();

        String jsonPayload = String.format("""
            {
              "model": "%s",
              "messages": [
                {
                  "role": "system",
                  "content": "Проверь код написанный начинающим разработчиком на Java. Дай советы по улучшению. Не возвращай в ответе исохдный либо исправленный кол, возвращай только список советов"
                },
                {
                  "role": "user",
                  "content": "%s"
                }
              ],
              "temperature": 0.87,
              "n": 1,
              "top_p":0.47,
              "max_tokens":512,
              "repetition_penalty":1.07,
              "stream":false,
              "update_interval":0
            }""", model, URLEncoder.encode(content, StandardCharsets.UTF_8));

        String response = gigaChatGenFeignClient.getAnswer("Bearer " + token, jsonPayload);
        return new ObjectMapper().readTree(response)
                .get("choices")
                .get(0)
                .get("message")
                .get("content")
                .asText();
//        return response.substring(response.indexOf("choices") + 33, response.length() - 224);
    }
}
