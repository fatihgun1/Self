package com.self.api.core.service.impl;

import com.self.api.core.dao.AreaDao;
import com.self.api.core.model.AreaModel;
import com.self.api.core.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class DefaultAreaService implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public void crateArea() {
        AreaModel areaModel = new AreaModel();
        areaModel.setName("Area Test");
        areaModel.setCode("code");
        areaDao.save(areaModel);
    }

    @Override
    public void deleteArea(AreaModel statusModel) {
        areaDao.delete(statusModel);
    }

    @Override
    public AreaModel getAreaByCode(String code) {
        return areaDao.getAreaByCode(code);
    }

    @Override
    public List<AreaModel> getAllArea() {
        return areaDao.findAll();
    }
}
