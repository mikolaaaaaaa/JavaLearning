package com.mikola.javalearningclient.client;

import com.mikola.javalearningclient.dto.TaskDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "task-service", url = "http://localhost:8081/api/v1/tasks")
public interface TaskFeignClient {

    @GetMapping()
    List<TaskDto> getTasks();

    @GetMapping("/{taskId}")
    TaskDto getTaskById(@PathVariable("taskId") Long taskId);

}
