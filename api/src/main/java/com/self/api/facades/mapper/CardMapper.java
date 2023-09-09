package com.self.api.facades.mapper;

import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import com.self.api.core.model.enumtype.NoteType;
import com.self.api.core.service.AreaService;
import com.self.api.core.service.StatusService;
import com.self.api.facades.dto.CardDTO;
import com.self.api.facades.dto.StatusDTO;
import com.self.api.general.GenerateUID;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class CardMapper {



    public static CardModel toMapCartModelMapping(CardDTO source){
        CardModel cardModel = new CardModel();
        cardModel.setTitle(source.getTitle());
        cardModel.setDescription(source.getDescription());
        cardModel.setCode(GenerateUID.generateCode());
        cardModel.setNoteType(resolveNoteType(source.getNoteType()));
        cardModel.setOwner(source.getOwner());
        cardModel.setModifyTime(new Date());
        return cardModel;

    }

    public static CardDTO toMapCardDto(CardModel source){
        CardDTO card = new CardDTO();
        card.setCode(source.getCode());
        card.setTitle(source.getTitle());
        card.setStatus(StatusMapper.toMapStatusDtoMapping(source.getStatus()));
        card.setDescription(source.getDescription());
        card.setNoteType(source.getNoteType().name());
        card.setOwner(source.getOwner());
        return card;
    }




    private static NoteType resolveNoteType(String string){
        if (NoteType.NOTE.name().equals(string)){
            return NoteType.NOTE;
        }
        else if (NoteType.VIDEO.name().equals(string)){
            return NoteType.VIDEO;
        }
        return NoteType.DEFAULT;
    }
}
