package com.self.api.facades.facade;

import com.self.api.facades.dto.AreaDTO;

import java.util.List;

public interface AreaFacade {

    void createArea(AreaDTO areaDTO);
    AreaDTO getAreaByCode(String code);
    void deleteArea(String code);
    List<AreaDTO> getAllArea();

}
