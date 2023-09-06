package com.self.api.webservice.controller;

import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.CardService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/card",method = RequestMethod.GET)
public class CardController {
    @Resource(name = "cardService")
    private CardService cardService;
    @PutMapping("/create")
    public ResponseEntity<String> createCard(){
        cardService.createCard();
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<CardModel> getCardsByCode(@PathVariable String code){
        CardModel status = cardService.getCardById(Long.valueOf(code));
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteStatus(@PathVariable String code){
        CardModel status = cardService.getCardById(Long.valueOf(code));
        cardService.deleteCard(status);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<List<CardModel>> getCards(){
        return ResponseEntity.ok(cardService.getAllCards());
    }

}
