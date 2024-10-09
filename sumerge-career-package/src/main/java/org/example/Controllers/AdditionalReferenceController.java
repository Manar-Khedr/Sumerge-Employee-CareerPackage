package org.example.Controllers;

import org.example.Mappers.AdditionalReferenceDTO;
import org.example.Services.AdditionalReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/additonalReferences")
public class AdditionalReferenceController {

    @Autowired
    private AdditionalReferenceService additionalReferenceService;

    @PostMapping
    public ResponseEntity<String> createAdditionalReference(@RequestBody AdditionalReferenceDTO additionalReferenceDTO){
        additionalReferenceService.createAdditionalReference(additionalReferenceDTO);
        return ResponseEntity.ok("Additoinal Reference created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAdditionalReference(@RequestBody String title){
        additionalReferenceService.deleteAdditionalReference(title);
        return ResponseEntity.ok("Additoinal Reference deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateAdditonalReference(@RequestBody AdditionalReferenceDTO additionalReferenceDTO){
        additionalReferenceService.updateAdditonalReference(additionalReferenceDTO);
        return ResponseEntity.ok("Additoinal Reference updated");
    }

    @GetMapping("/{title}")
    public ResponseEntity<AdditionalReferenceDTO> getAdditionalReference(@PathVariable String title){
        return ResponseEntity.ok(additionalReferenceService.getAdditionalReference(title));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdditionalReferenceDTO>> getAllAdditionalReference(){
        return ResponseEntity.ok(additionalReferenceService.getAllAdditionalReference());
    }
}
