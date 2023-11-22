package com.mikola.java_learn_api.service;

import com.mikola.java_learn_api.dto.TaskDto;
import com.mikola.java_learn_api.entity.Task;
import com.mikola.java_learn_api.exception.NotFoundException;
import com.mikola.java_learn_api.mapper.TaskMapper;
import com.mikola.java_learn_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException(""));

    }

    public Task addTask(TaskDto taskDTO) {
        return taskRepository.save(taskMapper.toEntity(taskDTO));
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
