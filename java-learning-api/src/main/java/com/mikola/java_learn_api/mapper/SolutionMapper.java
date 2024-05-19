package com.mikola.java_learn_api.mapper;

import com.mikola.java_learn_api.dto.SolutionDto;
import com.mikola.java_learn_api.entity.Solution;
import org.mapstruct.Mapper;

@Mapper
public interface SolutionMapper {
    SolutionDto toDto(Solution solution);

    Solution toEntity(SolutionDto solutionDto);
}
