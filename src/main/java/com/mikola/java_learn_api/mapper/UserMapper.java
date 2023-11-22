package com.mikola.java_learn_api.mapper;

import com.mikola.java_learn_api.dto.UserDto;
import com.mikola.java_learn_api.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);


    User toEntity(UserDto userDto);
}
