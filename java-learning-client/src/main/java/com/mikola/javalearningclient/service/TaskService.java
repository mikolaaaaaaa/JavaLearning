package com.mikola.javalearningclient.service;

import com.mikola.javalearningclient.client.TaskFeignClient;
import com.mikola.javalearningclient.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskFeignClient taskFeignClient;



    public List<TaskDto> getAllTasks() {
        return taskFeignClient.getTasks();
    }
}