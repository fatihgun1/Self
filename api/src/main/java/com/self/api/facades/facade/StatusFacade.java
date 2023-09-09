package com.self.api.facades.facade;

import com.self.api.facades.dto.StatusDTO;

import java.util.List;

public interface StatusFacade {
    void createStatus(StatusDTO statusDTO);
    StatusDTO getStatusByCode(String code);
    void deleteStatusByCode(String code);
    List<StatusDTO> getStatuses();
}
