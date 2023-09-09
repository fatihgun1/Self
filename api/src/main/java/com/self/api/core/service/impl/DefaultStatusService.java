package com.self.api.core.service.impl;

import com.self.api.core.dao.StatusDao;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.StatusService;
import com.self.api.general.GenerateUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("statusService")
public class DefaultStatusService implements StatusService {
    @Autowired
    private StatusDao statusDao;

    @Override
    public StatusModel crateStatus(StatusModel statusModel) {
        statusModel.setCode(GenerateUID.generateCode());
        statusModel.setModifyTime(new Date());
        return statusDao.save(statusModel);
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
