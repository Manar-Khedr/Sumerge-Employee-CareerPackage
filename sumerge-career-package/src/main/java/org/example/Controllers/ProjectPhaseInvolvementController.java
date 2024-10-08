package org.example.Controllers;

import org.example.Mappers.ProjectInvolvementPhaseDTO;
import org.example.Services.ProjectInvolvementPhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectInvolvementPhases")
public class ProjectPhaseInvolvementController {

    @Autowired
    private ProjectInvolvementPhaseService projectInvolvementPhaseService;

    @PostMapping
    public ResponseEntity<String> createProjectInvolvementPhase(@RequestBody ProjectInvolvementPhaseDTO projectInvolvementPhaseDTO){
        projectInvolvementPhaseService.createProjectInvolvementPhase(projectInvolvementPhaseDTO);
        return ResponseEntity.ok("Project Involvement Phase created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProjectPhaseInvolvementPhase(@RequestBody int id){
        projectInvolvementPhaseService.deleteProjectPhaseInvolvementPhase(id);
        return ResponseEntity.ok("Project Involvement Phase deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateProjectInvolvementPhase(@RequestBody ProjectInvolvementPhaseDTO projectInvolvementPhaseDTO){
        projectInvolvementPhaseService.updateProjectInvolvementPhase(projectInvolvementPhaseDTO);
        return ResponseEntity.ok("Project Involvement Phase updated");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectInvolvementPhaseDTO> getProjectInvolvementPhase(@PathVariable int id){
        return ResponseEntity.ok(projectInvolvementPhaseService.getProjectInvolvementPhase(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectInvolvementPhaseDTO>> getAllProjectInvolvementPhases(){
        return ResponseEntity.ok(projectInvolvementPhaseService.getAllProjectInvolvementPhases());
    }

}
