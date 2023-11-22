package com.mikola.java_learn_api.service;

import com.mikola.java_learn_api.dto.UserDto;
import com.mikola.java_learn_api.entity.User;
import com.mikola.java_learn_api.exception.NotFoundException;
import com.mikola.java_learn_api.mapper.UserMapper;
import com.mikola.java_learn_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional
                .orElseThrow(() -> new NotFoundException("User with ID " + userId + " not found"));
    }

    public User addUser(UserDto userDto) {
        return userRepository.save(userMapper.toEntity(userDto));
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

