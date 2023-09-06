package com.self.api.webservice.controller;

import com.self.api.core.model.CardModel;
import com.self.api.core.model.StatusModel;
import com.self.api.core.service.StatusService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/status",method = RequestMethod.GET)
public class StatusController {

    @Resource(name = "statusService")
    private StatusService statusService;

    @PutMapping("/create")
    public ResponseEntity<String> createCard(){
        statusService.crateStatus();
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<StatusModel> getStatusByCode(@PathVariable String code){
        StatusModel status = statusService.getStatusByCode(code);
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteStatus(@PathVariable String code){
        StatusModel status = statusService.getStatusByCode(code);
        statusService.deleteStatus(status);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<List<StatusModel>> getStatuses(){
        return ResponseEntity.ok(statusService.getAllStatus());
    }
}
