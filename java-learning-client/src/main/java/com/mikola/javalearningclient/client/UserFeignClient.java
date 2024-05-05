package com.mikola.javalearningclient.client;

import com.mikola.javalearningclient.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", url = "http://localhost:8081/api/v1/users")
public interface UserFeignClient {

    @GetMapping("/{userId}")
    UserDto getUserById(@PathVariable("userId") Long userId);

    @GetMapping("/email/{userEmail}")
    UserDto getUserByEmail(@PathVariable("userEmail") String userEmail);

    @PatchMapping
    UserDto updateUser(@RequestBody UserDto updatedUser);
}

