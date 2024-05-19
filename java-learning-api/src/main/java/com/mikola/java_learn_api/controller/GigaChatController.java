package com.mikola.java_learn_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mikola.java_learn_api.service.GigaChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/chat")
@RequiredArgsConstructor
@Slf4j
public class GigaChatController {
    private final GigaChatService gigaChatService;

    @GetMapping()
    public String sayHello() throws JsonProcessingException {
       return gigaChatService.getAnswer("Скажи Привет разработчику этого запроса");
    }
}
