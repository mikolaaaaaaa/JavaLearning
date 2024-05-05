package com.mikola.javalearningclient.service;


import com.mikola.javalearningclient.client.UserFeignClient;
import com.mikola.javalearningclient.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public UserDto getUserById(Long id) {
        return userFeignClient.getUserById(id);
    }

    public UserDto getUserByEmail(String email) {
        return userFeignClient.getUserByEmail(email);
    }

    public UserDto updateUser(UserDto userDto) {
        return userFeignClient.updateUser(userDto);
    }

    public UserDto getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }
        return getUserByEmail(email);
    }

}
