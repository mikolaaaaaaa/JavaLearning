package com.mikola.javalearningclient.service;

import com.mikola.javalearningclient.client.SolutionFeignClient;
import com.mikola.javalearningclient.dto.SolutionDto;
import com.mikola.javalearningclient.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionFeignClient solutionFeignClient;
    private final UserService userService;

    public List<SolutionDto> getAllSolutions() {
        return solutionFeignClient.getSolutions();
    }

    public List<SolutionDto> getAllSolutionsByUser(Long userId) {
        return solutionFeignClient.getSolutionsByUserId(userId);
    }

    public SolutionDto addSolution(TaskDto taskDto) {
        var user = userService.getCurrentUser();
        var solution = SolutionDto.builder()
                .user(user)
                .task(taskDto)
                .code(taskDto.getInitialCode())
                .submissionTimestamp(LocalDateTime.now())
                .build();
        var addedSolution = solutionFeignClient.addSolution(solution);
        solutionFeignClient.checkSolution(addedSolution.getSolutionId());
        return solutionFeignClient.getSolutionById(addedSolution.getSolutionId());
    }

    public SolutionDto getSolutionById(Long solutionId) {
        return solutionFeignClient.getSolutionById(solutionId);
    }
}
