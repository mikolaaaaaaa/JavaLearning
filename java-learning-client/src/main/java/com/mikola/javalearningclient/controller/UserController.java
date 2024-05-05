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

    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "user";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId, Model model) {
        var userDto = userService.getUserById(userId);
        model.addAttribute("user", userDto);
        return "user";
    }

    @PostMapping("")
    public String updateUser(@ModelAttribute UserDto updatedUserDto, Model model) {
        userService.updateUser(updatedUserDto);
        model.addAttribute("user", updatedUserDto);
        return "user";
    }

}
