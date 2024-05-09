package com.mikola.javalearningclient.controller;

import com.mikola.javalearningclient.dto.TaskDto;
import com.mikola.javalearningclient.service.SolutionService;
import com.mikola.javalearningclient.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final SolutionService solutionService;

    @GetMapping
    public String getTask(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        System.out.println();
        return "tasks";
    }

    @GetMapping("/{taskId}")
    public String viewTask(@PathVariable Long taskId, Model model) {
        model.addAttribute("task", taskService.getTaskById(taskId)); // Передаем taskId в модель
        return "task";
    }

    @PostMapping("/submit")
    public String submitTask(@ModelAttribute TaskDto taskDto, Model model) throws UnsupportedEncodingException {
        System.out.println("Received task: " + taskDto);
        model.addAttribute("chackResult", "test data");
        var solution = solutionService.addSolution(taskDto);
        model.addAttribute("solution", solution);
        return "redirect:/solutions/" + solution.getSolutionId();
    }
}
