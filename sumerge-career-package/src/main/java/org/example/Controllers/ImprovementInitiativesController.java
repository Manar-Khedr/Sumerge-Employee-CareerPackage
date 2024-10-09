package org.example.Controllers;

import org.example.Mappers.ImprovementInitiativesDTO;
import org.example.Services.ImprovementInitiativesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/improvementInitiatives")
public class ImprovementInitiativesController {

    @Autowired
    private ImprovementInitiativesService improvementInitiativesService;

    @PostMapping
    public ResponseEntity<String> createImprovementInitiatives(@RequestBody ImprovementInitiativesDTO improvementInitiativesDTO){
        improvementInitiativesService.createImprovementInitiatives(improvementInitiativesDTO);
        return ResponseEntity.ok("Improvement Initiatives created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteImprovementInitiatives(@RequestBody int id){
        improvementInitiativesService.deleteImprovementInitiatives(id);
        return ResponseEntity.ok("Improvement Initiatives deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateImprovementInitiatives(@RequestBody ImprovementInitiativesDTO improvementInitiativesDTO){
        improvementInitiativesService.updateImprovementInitiatives(improvementInitiativesDTO);
        return ResponseEntity.ok("Improvement Initiatives updated");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImprovementInitiativesDTO> getImprovementInitiatives(@PathVariable int id){
        return ResponseEntity.ok(improvementInitiativesService.getImprovementInitiatives(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ImprovementInitiativesDTO>> getAllImprovementInitiatives(){
        return ResponseEntity.ok(improvementInitiativesService.getAllImprovementInitiatives());
    }
}
