package com.mikola.java_learn_api.dto;

import com.mikola.java_learn_api.entity.Task;
import com.mikola.java_learn_api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolutionDto {
    private Long solutionId;
    private User user;
    private Task task;
    private String code;
    private boolean isCorrect;
    private String feedback;
    private LocalDateTime submissionTimestamp;

    // геттеры и сеттеры
}


