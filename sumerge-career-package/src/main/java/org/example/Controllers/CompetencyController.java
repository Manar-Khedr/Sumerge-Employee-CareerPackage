package org.example.Controllers;

import org.example.Mappers.CompetencyDTO;
import org.example.Services.CompetencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencies")
public class CompetencyController {

    @Autowired
    private CompetencyService competencyService;

    @PostMapping
    public ResponseEntity<String> createCompetency(@RequestBody CompetencyDTO competencyDTO){
        competencyService.createCompetency(competencyDTO);
        return ResponseEntity.ok("Competency created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCompetency(@RequestBody String title){
        competencyService.deleteCompetency(title);
        return ResponseEntity.ok("Competency deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateCompetency(@RequestBody CompetencyDTO competencyDTO){
        competencyService.updateCompetency(competencyDTO);
        return ResponseEntity.ok("Competency updated");
    }

    @GetMapping("/{title}")
    public ResponseEntity<CompetencyDTO> getCompetency(@PathVariable String title){
        return ResponseEntity.ok(competencyService.getCompetency(title));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompetencyDTO>> getAllCompetencies(){
        return ResponseEntity.ok(competencyService.getAllCompetencies());
    }
}
