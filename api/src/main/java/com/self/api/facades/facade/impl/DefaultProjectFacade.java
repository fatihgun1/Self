package com.self.api.facades.facade.impl;

import com.self.api.core.model.ProjectModel;
import com.self.api.core.service.ProjectService;
import com.self.api.facades.dto.ProjectDTO;
import com.self.api.facades.facade.ProjectFacade;
import com.self.api.facades.mapper.ProjectMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("projectFacade")
public class DefaultProjectFacade implements ProjectFacade {
    @Resource(name = "projectService")
    private ProjectService projectService;

    @Override
    public void crateProject(ProjectDTO statusModel) {
        projectService.crateProject(ProjectMapper.toMapProjectModel(statusModel));
    }

    @Override
    public void deleteProject(String code) {
        ProjectModel projectModel =projectService.getProjectByCode(code);
        if (Objects.nonNull(projectModel)){
            projectService.deleteProject(projectModel);
        }
    }

    @Override
    public ProjectDTO getProjectByCode(String code) {
        return ProjectMapper.toMapProjectDto(projectService.getProjectByCode(code));
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        List<ProjectDTO> projectModels = new ArrayList<>();
        List<ProjectModel> projectModelList = projectService.getAllProject();
        for (ProjectModel projectModel  : projectModelList){
            projectModels.add(ProjectMapper.toMapProjectDto(projectModel));
        }
        return projectModels;
    }
}
