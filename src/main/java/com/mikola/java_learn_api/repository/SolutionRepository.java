package com.mikola.java_learn_api.repository;

import com.mikola.java_learn_api.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
    List<Solution> findAllByUserId(Long userId);
}

