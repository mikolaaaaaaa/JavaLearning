package com.mikola.java_learn_api.mapper;

import com.mikola.java_learn_api.dto.TaskDto;
import com.mikola.java_learn_api.entity.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}
