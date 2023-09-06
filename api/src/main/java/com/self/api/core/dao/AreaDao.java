package com.self.api.core.dao;

import com.self.api.core.model.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AreaDao extends JpaRepository<AreaModel,Long> {
    @Query(value = "SELECT * FROM area s WHERE s.code = :code",nativeQuery = true)
    AreaModel getAreaByCode(@Param("code") String  code);
}
