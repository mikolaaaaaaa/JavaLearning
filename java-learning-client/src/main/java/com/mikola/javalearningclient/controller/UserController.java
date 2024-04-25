package com.mikola.javalearningclient.controller;

import com.mikola.javalearningclient.dto.UserDto;
import com.mikola.javalearningclient.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId, Model model) {
        UserDto userDto = userService.getUserById(userId);
        System.out.println("User from get: " + userDto);
        model.addAttribute("user", userDto);
        return "user";
    }

    @PatchMapping()
    public String updateUser(@ModelAttribute UserDto updatedUserDto, Model model) {
        System.out.println(updatedUserDto);
        userService.updateUser(updatedUserDto);
        model.addAttribute("user", updatedUserDto);
        return "user"; // Перенаправляем на страницу с информацией о пользователе
    }
}
