package com.mikola.java_learn_api.repository;

import com.mikola.java_learn_api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findTaskByTitle(String title);
}
