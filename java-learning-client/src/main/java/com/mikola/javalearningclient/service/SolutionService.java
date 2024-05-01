package com.mikola.javalearningclient.service;

import com.mikola.javalearningclient.client.SolutionFeignClient;
import com.mikola.javalearningclient.dto.SolutionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionFeignClient solutionFeignClient;

    public List<SolutionDto> getAllSolutions() {
        return solutionFeignClient.getSolutions();
    }

    public SolutionDto getSolutionById(Long solutionId) {
        return solutionFeignClient.getSolutionById(solutionId);
    }
}
