package com.self.api.core.dao;

import com.self.api.core.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardDao extends JpaRepository<CardModel,Long> {
    @Query(value = "SELECT * FROM card c WHERE c.code = :code",nativeQuery = true)
    CardModel getCartById(@Param("code") String  code);
}
