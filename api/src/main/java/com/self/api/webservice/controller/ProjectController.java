package com.self.api.webservice.controller;

import com.self.api.facades.dto.ProjectDTO;
import com.self.api.facades.dto.StatusDTO;
import com.self.api.facades.facade.ProjectFacade;
import com.self.api.facades.facade.StatusFacade;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/project",method = RequestMethod.GET)
public class ProjectController {

    @Resource(name = "projectFacade")
    private ProjectFacade projectFacade;

    @PutMapping("/create")
    public ResponseEntity<String> createStatus(@RequestBody ProjectDTO statusDTO){
        projectFacade.crateProject(statusDTO);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<ProjectDTO> getStatusByCode(@PathVariable String code){
        return ResponseEntity.ok(projectFacade.getProjectByCode(code));
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteStatus(@PathVariable String code){
        projectFacade.deleteProject(code);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDTO>> getStatuses(){
        return ResponseEntity.ok(projectFacade.getAllProject());
    }
}
