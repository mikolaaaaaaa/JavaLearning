package com.mikola.java_learn_api.service;

import com.mikola.java_learn_api.dto.TaskDto;
import com.mikola.java_learn_api.request.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GigaChatService {
    public List<Message> generateMessagesForCheckTask(TaskDto taskDto) {
        return List.of(
                new Message("system", "Тебе дан код начинающего программиста на Java, проверь его и дай рекоммендации по улучшению"),
                new Message("user", taskDto.getInitialCode())
        );
    }
}
