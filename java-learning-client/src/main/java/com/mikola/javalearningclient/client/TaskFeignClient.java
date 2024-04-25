package com.mikola.javalearningclient.client;

import com.mikola.javalearningclient.dto.TaskDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "task-service", url = "http://localhost:8081/api/v1") // указываем имя сервиса и URL
public interface TaskFeignClient {

    @GetMapping("/tasks") // указываем метод запроса и путь
    List<TaskDto> getTasks();

    @GetMapping("/tasks/{taskId}")
    TaskDto getTaskById(@PathVariable("taskId") Long taskId);

}
