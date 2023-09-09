package com.self.api.webservice.controller;

import com.self.api.core.model.AreaModel;
import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.AreaService;
import com.self.api.core.service.StatusService;
import com.self.api.facades.dto.AreaDTO;
import com.self.api.facades.facade.AreaFacade;
import com.self.api.facades.facade.CardFacade;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/area",method = RequestMethod.GET)
public class AreaController {

    @Resource(name = "areaFacade")
    private AreaFacade areaFacade;

    @PutMapping("/create")
    public ResponseEntity<String> createArea(@RequestBody AreaDTO areaDTO){
        areaFacade.createArea(areaDTO);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<AreaDTO> getAreaByCode(@PathVariable String code){
        return ResponseEntity.ok(areaFacade.getAreaByCode(code));
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteArea(@PathVariable String code){
        areaFacade.deleteArea(code);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<List<AreaDTO>> getCards(){
        return ResponseEntity.ok(areaFacade.getAllArea());
    }
}
