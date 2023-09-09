package com.self.api.core.service;

import com.self.api.core.model.ProjectModel;

import java.util.List;

public interface ProjectService {
    ProjectModel crateProject(ProjectModel statusModel);
    void deleteProject(ProjectModel statusModel);
    ProjectModel getProjectByCode(String code);
    List<ProjectModel> getAllProject();
}
