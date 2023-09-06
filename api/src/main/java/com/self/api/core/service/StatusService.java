package com.self.api.core.service;

import com.self.api.core.model.StatusModel;

import java.util.List;

public interface StatusService {
    void crateStatus();
    void deleteStatus(StatusModel statusModel);
    StatusModel getStatusByCode(String code);
    List<StatusModel>  getAllStatus();

}
