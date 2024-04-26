package com.mikola.java_learn_api.controller;

import com.mikola.java_learn_api.dto.UserDto;
import com.mikola.java_learn_api.entity.User;
import com.mikola.java_learn_api.mapper.UserMapper;
import com.mikola.java_learn_api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream().map(userMapper::toDto).toList();
    }

//    @GetMapping("/login")
//    public Optional<UserDto> login() {
//        List<User> users = userService.getAllUsers();
//        return users.stream().map(userMapper::toDto).toList();
//    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return userMapper.toDto(userService.getUserById(userId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDTO) {
        log.debug("User DTO: {}", userDTO);
        return userMapper.toDto(userService.addUser(userDTO));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PatchMapping()
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.toDto(userService.updateUser(userDto));
    }
}
