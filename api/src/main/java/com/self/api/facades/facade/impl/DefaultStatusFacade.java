package com.self.api.facades.facade.impl;

import com.self.api.core.model.StatusModel;
import com.self.api.core.service.StatusService;
import com.self.api.facades.dto.StatusDTO;
import com.self.api.facades.facade.StatusFacade;
import com.self.api.facades.mapper.StatusMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("statusFacade")
public class DefaultStatusFacade implements StatusFacade {
    @Resource(name = "statusService")
    private StatusService statusService;

    @Override
    public void createStatus(StatusDTO statusDTO) {
        statusService.crateStatus(StatusMapper.toMapStatusModelMapping(statusDTO));
    }

    @Override
    public StatusDTO getStatusByCode(String code) {
        return StatusMapper.toMapStatusDtoMapping(statusService.getStatusByCode(code));
    }

    @Override
    public void deleteStatusByCode(String code) {
        StatusModel statusModel = statusService.getStatusByCode(code);
        if (Objects.nonNull(statusModel)){
            statusService.deleteStatus(statusModel);
        }
    }

    @Override
    public List<StatusDTO> getStatuses() {
        List<StatusDTO> statusDTOList = new ArrayList<>();
        List<StatusModel> statusModels = statusService.getAllStatus();
        for (StatusModel statusModel : statusModels){
            statusDTOList.add(StatusMapper.toMapStatusDtoMapping(statusModel));
        }
        return statusDTOList;
    }
}
