package com.mikola.java_learn_api.repository;

import com.mikola.java_learn_api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Дополнительные методы могут быть добавлены по мере необходимости
}
