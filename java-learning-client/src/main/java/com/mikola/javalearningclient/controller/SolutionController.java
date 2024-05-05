package com.mikola.javalearningclient.controller;

import com.mikola.javalearningclient.service.SolutionService;
import com.mikola.javalearningclient.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solutions")
@RequiredArgsConstructor
public class SolutionController {

    private final SolutionService solutionService;
    private final UserService userService;

    @GetMapping
    public String getSolutions(Model model) {
        model.addAttribute("solutions", solutionService.getAllSolutions());
        return "solutions";
    }

    @GetMapping("user")
    public String getSolutionsByUser(Model model) {
        model.addAttribute("solutions", solutionService.getAllSolutionsByUser(userService.getCurrentUser().getId()));
        return "solutions";
    }

    @GetMapping("/{solutionId}")
    public String viewSolution(@PathVariable Long solutionId, Model model) {
        model.addAttribute("solution", solutionService.getSolutionById(solutionId));
        return "solution";
    }
}
