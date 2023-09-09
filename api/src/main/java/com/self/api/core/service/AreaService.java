package com.self.api.core.service;

import com.self.api.core.model.AreaModel;
import com.self.api.core.model.StatusModel;

import java.util.List;

public interface AreaService {
    void crateArea(AreaModel areaModel);
    void deleteArea(AreaModel statusModel);
    AreaModel getAreaByCode(String code);
    List<AreaModel> getAllArea();
}
