package com.self.api.facades.mapper;

import com.self.api.core.model.AreaModel;
import com.self.api.facades.dto.AreaDTO;
import org.springframework.stereotype.Service;

@Service
public class AreaMapper {
    public static AreaModel toMapAreaModel(AreaDTO source){
        AreaModel areaModel = new AreaModel();
        areaModel.setCode(source.getCode());
        areaModel.setName(source.getName());
        return areaModel;
    }

    public static AreaDTO toMapAreaDto(AreaModel source){
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setCode(source.getCode());
        areaDTO.setName(source.getName());
        return areaDTO;
    }
}
