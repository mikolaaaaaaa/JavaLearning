package com.mikola.java_learn_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mikola.java_learn_api.dto.SolutionDto;
import com.mikola.java_learn_api.mapper.SolutionMapper;
import com.mikola.java_learn_api.service.SolutionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/solution")
@RequiredArgsConstructor
@Slf4j
public class SolutionController {
    private final SolutionService solutionService;
    private final SolutionMapper solutionMapper;

    @GetMapping
    public List<SolutionDto> getAllSolutions() {
        return solutionService.getAllSolutions()
                .stream()
                .map(solutionMapper::toDto)
                .toList();
    }

    @GetMapping("/user/{userId}")
    public List<SolutionDto> getSolutionByUserId(@PathVariable Long userId) {
        return solutionService.getAllByUserId(userId)
                .stream()
                .map(solutionMapper::toDto)
                .toList();
    }

    @GetMapping("/{solutionId}")
    public SolutionDto getSolutionById(@PathVariable Long solutionId) {
        return solutionMapper.toDto(solutionService.getSolutionById(solutionId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SolutionDto addSolution(@RequestBody SolutionDto solutionDto) {
        return solutionMapper.toDto(solutionService.addSolution(solutionDto));
    }

    @DeleteMapping("/{solutionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSolution(@PathVariable Long solutionId) {
        solutionService.deleteSolution(solutionId);
    }

    @PostMapping("/check/{solutionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void checkSolution(@PathVariable Long solutionId) throws JsonProcessingException {
        solutionService.checkSolution(solutionId);
    }
}
