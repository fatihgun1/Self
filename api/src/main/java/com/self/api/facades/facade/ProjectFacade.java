package com.self.api.facades.facade;

import com.self.api.facades.dto.ProjectDTO;

import java.util.List;

public interface ProjectFacade {
    void crateProject(ProjectDTO statusModel);
    void deleteProject(String code);
    ProjectDTO getProjectByCode(String code);
    List<ProjectDTO> getAllProject();
}
