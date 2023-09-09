package com.self.api.core.service;

import com.self.api.core.model.StatusModel;

import java.util.List;

public interface StatusService {
    StatusModel crateStatus(StatusModel statusModel);
    void deleteStatus(StatusModel statusModel);
    StatusModel getStatusByCode(String code);
    List<StatusModel>  getAllStatus();

}
