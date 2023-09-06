package com.self.api.webservice.controller;

import com.self.api.core.model.AreaModel;
import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.AreaService;
import com.self.api.core.service.StatusService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/area",method = RequestMethod.GET)
public class AreaController {

    @Resource(name = "areaService")
    private AreaService areaService;

    @PutMapping("/create")
    public ResponseEntity<String> createCard(){
        areaService.crateArea();
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<AreaModel> getStatusByCode(@PathVariable String code){
        AreaModel status = areaService.getAreaByCode(code);
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteStatus(@PathVariable String code){
        AreaModel status = areaService.getAreaByCode(code);
        areaService.deleteArea(status);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<List<AreaModel>> getCards(){
        return ResponseEntity.ok(areaService.getAllArea());
    }
}
