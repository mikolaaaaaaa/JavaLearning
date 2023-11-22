package com.mikola.java_learn_api.repository;

import com.mikola.java_learn_api.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
    // Дополнительные методы могут быть добавлены по мере необходимости
}

