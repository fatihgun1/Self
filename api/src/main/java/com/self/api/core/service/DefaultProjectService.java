package com.self.api.core.service;

import com.self.api.core.dao.ProjectDao;
import com.self.api.core.model.ProjectModel;
import com.self.api.general.GenerateUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("projectService")
public class DefaultProjectService implements ProjectService{

    @Autowired
    private ProjectDao projectDao;
    @Override
    public ProjectModel crateProject(ProjectModel statusModel) {
        statusModel.setCode(GenerateUID.generateCode());
        return projectDao.save(statusModel);
    }

    @Override
    public void deleteProject(ProjectModel statusModel) {
        projectDao.delete(statusModel);
    }

    @Override
    public ProjectModel getProjectByCode(String code) {
        return projectDao.getProjectByCode(code);
    }

    @Override
    public List<ProjectModel> getAllProject() {
        return projectDao.findAll();
    }
}
