package com.mikola.javalearningclient.service;


import com.mikola.javalearningclient.client.UserFeignClient;
import com.mikola.javalearningclient.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public UserDto getUserById(Long id) {
        return userFeignClient.getUserById(id);
    }

    public UserDto updateUser(UserDto userDto) {
      return userFeignClient.updateUser(userDto);
    }

}
