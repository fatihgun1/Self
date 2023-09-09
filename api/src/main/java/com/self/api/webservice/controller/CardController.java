package com.self.api.webservice.controller;

import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.CardService;
import com.self.api.facades.dto.CardDTO;
import com.self.api.facades.facade.CardFacade;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/card",method = RequestMethod.GET)
public class CardController {
    @Resource(name = "cardFacade")
    private CardFacade cardFacade;

    @PutMapping("/create")
    public ResponseEntity<String> createCard(@RequestBody CardDTO card){
        cardFacade.createCard(card);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<CardDTO> getCardsByCode(@PathVariable String code){
        return ResponseEntity.ok(cardFacade.getCardByCode(code));
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteStatus(@PathVariable String code){
        cardFacade.deleteCardByCode(code);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<List<CardDTO>> getCards(){
        return ResponseEntity.ok(cardFacade.getAllCard());
    }

}
