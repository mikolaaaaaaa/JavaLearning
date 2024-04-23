package com.mikola.javalearningclient.controller;

import com.mikola.javalearningclient.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @RequestMapping(value = "/tasks")
    public String getTask(Model model) {
        model.addAttribute("something", "this is come from controller");
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }
}
