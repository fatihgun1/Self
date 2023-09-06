package com.self.api.core.dao;

import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusDao extends JpaRepository<StatusModel,Long> {
    @Query(value = "SELECT * FROM status s WHERE s.code = :code",nativeQuery = true)
    StatusModel getStatusByCode(@Param("code") String  code);
}
