package com.mikola.javalearningclient.client;

import com.mikola.javalearningclient.dto.SolutionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "solution-service", url = "http://localhost:8081/api/v1/solution")
public interface SolutionFeignClient {
    @GetMapping()
    List<SolutionDto> getSolutions();

    @PostMapping
    SolutionDto addSolution(SolutionDto solutionDto);

    @GetMapping("/user/{userId}")
    List<SolutionDto> getSolutionsByUserId(@PathVariable Long userId);

    @PostMapping("/check/{solutionId}")
    void checkSolution(@PathVariable Long solutionId);

    @GetMapping("/{solutionId}")
    SolutionDto getSolutionById(@PathVariable("solutionId") Long solutionId);

}
