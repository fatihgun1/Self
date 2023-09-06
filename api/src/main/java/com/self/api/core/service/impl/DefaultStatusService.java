package com.self.api.core.service.impl;

import com.self.api.core.dao.StatusDao;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("statusService")
public class DefaultStatusService implements StatusService {
    @Autowired
    private StatusDao statusDao;

    @Override
    public void crateStatus() {
        StatusModel statusModel = new StatusModel();
        statusModel.setCode("code");
        statusModel.setName("Code Test");
        statusDao.save(statusModel);
    }

    @Override
    public void deleteStatus(StatusModel statusModel) {
        statusDao.delete(statusModel);
    }

    @Override
    public StatusModel getStatusByCode(String code) {
        return statusDao.getStatusByCode(code);
    }

    @Override
    public List<StatusModel> getAllStatus() {
        return statusDao.findAll();
    }
}
