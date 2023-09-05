package com.self.api.core.service;

import com.self.api.core.model.CardModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CardService {

    void createCard();

    void getCardById(Long id);

    List<CardModel> getAllCards();
}
