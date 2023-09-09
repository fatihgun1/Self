package com.self.api.facades.facade;

import com.self.api.facades.dto.CardDTO;

import java.util.List;

public interface CardFacade {

    void createCard(CardDTO card);
    CardDTO getCardByCode(String code);
    void deleteCardByCode(String code);
    List<CardDTO> getAllCard();

}
