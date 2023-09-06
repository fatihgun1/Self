package com.self.api.core.service.impl;

import com.self.api.core.dao.CardDao;
import com.self.api.core.model.CardModel;
import com.self.api.core.model.enumtype.NoteType;
import com.self.api.core.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("cardService")
public class DefaultCardService implements CardService {
    @Autowired
    private CardDao cardDao;
    @Override
    public void createCard() {
        CardModel card = new CardModel();
        card.setDescription("Title");
        card.setDescription("Description");
        card.setNoteType(NoteType.DEFAULT);
        card.setModifyTime(new Date());
        cardDao.save(card);
    }

    @Override
    public void deleteCard(CardModel card) {
        cardDao.delete(card);
    }

    @Override
    public CardModel getCardById(Long id) {
        return cardDao.getCartById(id);
    }

    @Override
    public List<CardModel> getAllCards() {
        return cardDao.findAll();
    }
}
