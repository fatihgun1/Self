package com.self.api.facades.facade.impl;

import com.self.api.core.model.AreaModel;
import com.self.api.core.service.AreaService;
import com.self.api.facades.dto.AreaDTO;
import com.self.api.facades.facade.AreaFacade;
import com.self.api.facades.mapper.AreaMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("areaFacade")
public class DefaultAreaFacade implements AreaFacade {
    @Resource(name = "areaService")
    private AreaService areaService;

    @Override
    public void createArea(AreaDTO areaDTO) {
        areaService.crateArea(AreaMapper.toMapAreaModel(areaDTO));
    }

    @Override
    public AreaDTO getAreaByCode(String code) {
        return AreaMapper.toMapAreaDto(areaService.getAreaByCode(code));
    }

    @Override
    public void deleteArea(String code) {
        AreaModel areaModel = areaService.getAreaByCode(code);
        if (Objects.nonNull(areaModel)){
            areaService.deleteArea(areaModel);
        }
    }

    @Override
    public List<AreaDTO> getAllArea() {
        List<AreaDTO> areaDTOList = new ArrayList<>();
        List<AreaModel> areaModels =areaService.getAllArea();
        for(AreaModel areaModel : areaModels){
            areaDTOList.add(AreaMapper.toMapAreaDto(areaModel));
        }
        return areaDTOList;
    }
}
