package com.mikola.java_learn_api.controller;

import com.mikola.java_learn_api.dto.TaskDto;
import com.mikola.java_learn_api.mapper.TaskMapper;
import com.mikola.java_learn_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks()
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @GetMapping("/{taskId}")
    public TaskDto getTaskById(@PathVariable Long taskId) {
        return taskMapper.toDto(taskService.getTaskById(taskId));
    }

    @GetMapping("/task")
    public TaskDto getTaskByTitle(@RequestParam(value = "title") String title) {
        return taskMapper.toDto(taskService.getTaskByTitle(title));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto addTask(@RequestBody TaskDto taskDTO) {
        return taskMapper.toDto(taskService.addTask(taskDTO));
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
