package com.self.api.facades.mapper;

import com.self.api.core.model.StatusModel;
import com.self.api.facades.dto.StatusDTO;
import com.self.api.general.GenerateUID;
import org.springframework.stereotype.Service;

@Service
public class StatusMapper {

    public static StatusModel toMapStatusModelMapping(StatusDTO source){
        StatusModel status = new StatusModel();
        status.setName(source.getName());
        status.setCode(source.getCode());
        return status;
    }

    public static StatusDTO toMapStatusDtoMapping(StatusModel source){
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setCode(source.getCode());
        statusDTO.setName(source.getName());
        return statusDTO;
    }


}
