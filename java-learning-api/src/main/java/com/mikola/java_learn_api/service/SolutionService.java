package com.mikola.java_learn_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mikola.java_learn_api.dto.SolutionDto;
import com.mikola.java_learn_api.entity.Solution;
import com.mikola.java_learn_api.exception.NotFoundException;
import com.mikola.java_learn_api.mapper.SolutionMapper;
import com.mikola.java_learn_api.repository.SolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionRepository solutionRepository;
    private final SolutionMapper solutionMapper;
    private final GigaChatService gigaChatService;


    public void checkSolution(Long solutionId) throws JsonProcessingException {
        var optionalSolution = solutionRepository.findById(solutionId);
        var solution = solutionMapper.toDto(optionalSolution.orElseThrow(() -> new NotFoundException("")));
        var feedback = gigaChatService.getAnswer(solution.getCode());
        solution.setFeedback(feedback);
        solutionRepository.save(solutionMapper.toEntity(solution));
    }

    public List<Solution> getAllByUserId(Long userId) {
        return solutionRepository.findAllByUserId(userId);
    }

    public List<Solution> getAllSolutions() {
        return solutionRepository.findAll();
    }

    public Solution getSolutionById(Long solutionId) {
        return solutionRepository.findById(solutionId).orElseThrow(() -> new NotFoundException(""));
    }

    public Solution addSolution(SolutionDto solutionDTO) {
        return solutionRepository.save(solutionMapper.toEntity(solutionDTO));
    }

    public void deleteSolution(Long solutionId) {
        solutionRepository.deleteById(solutionId);
    }
}
