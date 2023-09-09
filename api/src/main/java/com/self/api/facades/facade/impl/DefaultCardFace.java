package com.self.api.facades.facade.impl;

import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.AreaService;
import com.self.api.core.service.CardService;
import com.self.api.core.service.StatusService;
import com.self.api.facades.dto.CardDTO;
import com.self.api.facades.facade.CardFacade;
import com.self.api.facades.mapper.CardMapper;
import com.self.api.facades.mapper.StatusMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("cardFacade")
public class DefaultCardFace implements CardFacade {
    @Resource(name = "cardService")
    private CardService cardService;
    @Resource(name = "statusService")
    private StatusService statusService;

    @Override
    public void createCard(CardDTO card) {
        CardModel cardModel = CardMapper.toMapCartModelMapping(card);

        StatusModel status = statusService.getStatusByCode(card.getCode());
        status = Objects.nonNull(status) ? status : statusService.crateStatus(StatusMapper.toMapStatusModelMapping(card.getStatus()));
        cardModel.setStatus(status);
        cardService.createCard(cardModel);
    }


    @Override
    public CardDTO getCardByCode(String code) {
        return CardMapper.toMapCardDto(cardService.getCardById(code));
    }

    @Override
    public void deleteCardByCode(String code) {
        CardModel cardModel = cardService.getCardById(code);
        if (Objects.nonNull(cardModel)){
            cardService.deleteCard(cardModel);
        }
    }

    @Override
    public List<CardDTO> getAllCard() {
        List<CardDTO> cardDTOList = new ArrayList<>();
        List<CardModel> cardModels = cardService.getAllCards();
        for (CardModel cardModel : cardModels){
            cardDTOList.add(CardMapper.toMapCardDto(cardModel));
        }
        return cardDTOList;
    }
}
