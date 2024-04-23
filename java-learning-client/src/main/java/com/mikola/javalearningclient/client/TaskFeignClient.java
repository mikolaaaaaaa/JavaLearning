package com.mikola.javalearningclient.client;

import com.mikola.javalearningclient.dto.TaskDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "task-service", url = "http://localhost:8081") // указываем имя сервиса и URL
public interface TaskFeignClient {

    @GetMapping("/api/v1/tasks") // указываем метод запроса и путь
    List<TaskDto> getTasks();
}
