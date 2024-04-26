package com.mikola.javalearningclient.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login"; // Перенаправляем на домашнюю страницу
    }

//    @PostMapping("/doLogin")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        Model model) {
//        // Здесь можно добавить логику проверки имени пользователя и пароля
//        // Предположим, что имя пользователя и пароль введены верно
//        // Затем можно выполнить редирект на другую страницу, например, домашнюю страницу
//
//        return "redirect:/tasks"; // Перенаправляем на домашнюю страницу
//    }
}
