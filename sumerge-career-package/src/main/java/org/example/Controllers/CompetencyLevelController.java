package org.example.Controllers;

import org.example.Mappers.CompetencyLevelDTO;
import org.example.Services.CompetencyLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencyLevels")
public class CompetencyLevelController {

    @Autowired
    private CompetencyLevelService competencyLevelService;

    @PostMapping
    public ResponseEntity<String> createCompetencyLevel(@RequestBody CompetencyLevelDTO competencyLevelDTO){
        competencyLevelService.createCompetencyLevel(competencyLevelDTO);
        return ResponseEntity.ok("Competency Level created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCompetencyLevel(@RequestBody int id){
        competencyLevelService.deleteCompetencyLevel(id);
        return ResponseEntity.ok("Competency Level deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateCompetencyLevel(@RequestBody CompetencyLevelDTO competencyLevelDTO){
        competencyLevelService.updateCompetencyLevel(competencyLevelDTO);
        return ResponseEntity.ok("Competency Level updated");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetencyLevelDTO> getCompetencyLevel(@PathVariable int id){
        return ResponseEntity.ok(competencyLevelService.getCompetencyLevel(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompetencyLevelDTO>> getAllCompetencyLevels(){
        return ResponseEntity.ok(competencyLevelService.getAllCompetencyLevels());
    }
}
