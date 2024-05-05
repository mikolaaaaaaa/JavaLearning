package com.mikola.java_learn_api.service;

import com.mikola.java_learn_api.client.MockChatGptClient;
import com.mikola.java_learn_api.dto.SolutionDto;
import com.mikola.java_learn_api.entity.Solution;
import com.mikola.java_learn_api.exception.NotFoundException;
import com.mikola.java_learn_api.mapper.SolutionMapper;
import com.mikola.java_learn_api.repository.SolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SolutionService {
    private final SolutionRepository solutionRepository;
    private final SolutionMapper solutionMapper;


    public void checkSolution(Long solutionId) {
        Optional<Solution> optionalSolution = solutionRepository.findById(solutionId);
        SolutionDto solution = solutionMapper.toDto(optionalSolution.orElseThrow(() -> new NotFoundException("")));
        String feedback = MockChatGptClient.executeQuery(solution.getCode());
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
