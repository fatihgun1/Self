package com.self.api.core.service;

import com.self.api.core.model.CardModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CardService {

    void createCard(CardModel cardModel);

    void deleteCard(CardModel card);

    CardModel getCardById(String code);

    List<CardModel> getAllCards();
}
