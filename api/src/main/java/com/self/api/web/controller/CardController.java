package com.self.api.web.controller;

import com.self.api.core.service.CardService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
