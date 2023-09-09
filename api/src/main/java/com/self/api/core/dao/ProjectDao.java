package com.self.api.core.dao;

import com.self.api.core.model.ProjectModel;
import com.self.api.core.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectDao extends JpaRepository<ProjectModel,Long> {
    @Query(value = "SELECT * FROM project s WHERE s.code = :code",nativeQuery = true)
    ProjectModel getProjectByCode(@Param("code") String  code);
}
