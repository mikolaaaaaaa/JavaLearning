package com.mikola.java_learn_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotBlank(message = "Заголовок задачи не может быть пустым")
    @Size(max = 255, message = "Заголовок задачи не может превышать 255 символов")
    private String title;

    @NotBlank(message = "Описание задачи не может быть пустым")
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String initialCode;

}

