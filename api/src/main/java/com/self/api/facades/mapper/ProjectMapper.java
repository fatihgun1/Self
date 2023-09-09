package com.self.api.facades.mapper;

import com.self.api.core.model.ProjectModel;
import com.self.api.facades.dto.ProjectDTO;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {
    public static ProjectModel toMapProjectModel(ProjectDTO source){
        ProjectModel projectModel = new ProjectModel();
        projectModel.setName(source.getName());
        return projectModel;
    }

    public static ProjectDTO toMapProjectDto(ProjectModel source){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setCode(source.getCode());
        projectDTO.setName(source.getName());
        return projectDTO;
    }
}
