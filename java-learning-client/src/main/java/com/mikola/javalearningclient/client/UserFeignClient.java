package com.mikola.javalearningclient.client;

import com.mikola.javalearningclient.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "http://localhost:8081/api/v1/users")
public interface UserFeignClient {

    @GetMapping("/{userId}")
    UserDto getUserById(@PathVariable("userId") Long userId);

    @PatchMapping
    UserDto updateUser(@RequestBody UserDto updatedUser);
}

