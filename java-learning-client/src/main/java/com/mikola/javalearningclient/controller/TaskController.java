package com.mikola.javalearningclient.controller;

import com.mikola.javalearningclient.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String getTask(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/{taskId}")
    public String viewTask(@PathVariable Long taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId)); // Передаем taskId в модель
        return "task";
    }

    @PostMapping("/submit")
    public String submitTask(@RequestBody String code, Model model) {
        // Здесь вы можете обработать отправленный код
        // Например, передать его на проверку и получить результат
        System.out.println("Received code: " + code);
        model.addAttribute("chackResult", "test data");
        return "success"; // Перенаправляем обратно на страницу задач
    }
}
