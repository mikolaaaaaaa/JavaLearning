package com.mikola.javalearningclient.dto;

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
    private UserDto user;
    private TaskDto task;
    private String code;
    private boolean isCorrect;
    private String feedback;
    private LocalDateTime submissionTimestamp;

}


