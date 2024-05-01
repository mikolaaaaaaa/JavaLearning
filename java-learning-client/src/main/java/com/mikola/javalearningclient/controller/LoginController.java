package com.mikola.javalearningclient.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LoginController {
//    @GetMapping("/login")
//    public String login(HttpServletRequest request) {
//        System.out.println("hello from /login: " + request);
//        return "login"; // Перенаправляем на домашнюю страницу
//    }

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
//@GetMapping("/loginSuccess")
//public String loginSuccess(HttpServletRequest request) {
//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    HttpSession session = request.getSession();
//    session.setAttribute("username", auth.getName()); // Пример сохранения имени пользователя в сессии
//    return "redirect:/tasks"; // Перенаправление на страницу после успешной аутентификации
//}
}
