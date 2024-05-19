package com.mikola.java_learn_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255, message = "Имя пользователя не может превышать 255 символов")
    private String name;

    @Size(max = 255, message = "Email не может превышать 255 символов")
    @Column(unique = true)
    private String email;

    @Size(max = 255, message = "Пароль не может превышать 255 символов")
    private String password;

}

