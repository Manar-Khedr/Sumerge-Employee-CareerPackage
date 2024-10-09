package org.example.Controllers;


import org.example.Mappers.OtherContributionsRequirementDTO;
import org.example.Services.OtherContributionsRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otherContributionsRequirements")
public class OtherContributionsRequirementController {

    @Autowired
    private OtherContributionsRequirementService otherContributionsRequirementService;


    @PostMapping
    public ResponseEntity<String> createOtherContributionsRequirement(@RequestBody OtherContributionsRequirementDTO otherContributionsRequirementDTO){
        otherContributionsRequirementService.createOtherContributionsRequirement(otherContributionsRequirementDTO);
        return ResponseEntity.ok("Other Contributions Requirement Created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOtherContributionsRequirement(@RequestBody int id){
        otherContributionsRequirementService.deleteOtherContributionsRequirement(id);
        return ResponseEntity.ok("Other Contributions Requirement deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateOtherContributionsRequirement(@RequestBody OtherContributionsRequirementDTO otherContributionsRequirementDTO){
        otherContributionsRequirementService.updateOtherContributionsRequirement(otherContributionsRequirementDTO);
        return ResponseEntity.ok("Other Contributions Requirement updated");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherContributionsRequirementDTO> getOtherContributionsRequirement(@RequestBody int id){
        return ResponseEntity.ok(otherContributionsRequirementService.getOtherContributionsRequirement(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OtherContributionsRequirementDTO>> getAllOtherContributionsRequirement(){
        return ResponseEntity.ok(otherContributionsRequirementService.getAllOtherContributionsRequirement());
    }
}
