package com.self.api.webservice.controller;

import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.StatusService;
import com.self.api.facades.dto.StatusDTO;
import com.self.api.facades.facade.StatusFacade;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/status",method = RequestMethod.GET)
public class StatusController {

    @Resource(name = "statusFacade")
    private StatusFacade statusFacade;

    @PutMapping("/create")
    public ResponseEntity<String> createStatus(@RequestBody StatusDTO statusDTO){
        statusFacade.createStatus(statusDTO);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<StatusDTO> getStatusByCode(@PathVariable String code){
        return ResponseEntity.ok(statusFacade.getStatusByCode(code));
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteStatus(@PathVariable String code){
        statusFacade.deleteStatusByCode(code);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<List<StatusDTO>> getStatuses(){
        return ResponseEntity.ok(statusFacade.getStatuses());
    }
}
