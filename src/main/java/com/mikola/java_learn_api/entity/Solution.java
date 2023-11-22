package com.mikola.java_learn_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Solutions")
@Getter
@Setter
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solutionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "Пользователь не может быть пустым")
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @NotNull(message = "Задача не может быть пустой")
    private Task task;

    @Lob
    @NotNull(message = "Код решения не может быть пустым")
    @Column(columnDefinition = "TEXT")
    private String code;

    private boolean isCorrect;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String feedback;

    @NotNull
    private LocalDateTime submissionTimestamp;

}

