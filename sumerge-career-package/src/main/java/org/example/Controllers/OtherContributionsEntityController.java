package org.example.Controllers;

import org.example.Mappers.OtherContributionsEntityDTO;
import org.example.Services.OtherContributionsEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otherContributionsEntities")
public class OtherContributionsEntityController {

    @Autowired
    private OtherContributionsEntityService otherContributionsEntityService;

    @PostMapping
    public ResponseEntity<String> createOtherContributionsEntity(@RequestBody OtherContributionsEntityDTO otherContributionsEntityDTO){
        otherContributionsEntityService.createOtherContributionsEntity(otherContributionsEntityDTO);
        return ResponseEntity.ok("Other Contributions Entity created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOtherContributionsEntity(@RequestBody int id){
        otherContributionsEntityService.deleteOtherContributionsEntity(id);
        return ResponseEntity.ok("Other Contributions Entity deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateOtherContributionsEntity(@RequestBody OtherContributionsEntityDTO otherContributionsEntityDTO){
        otherContributionsEntityService.updateOtherContributionsEntity(otherContributionsEntityDTO);
        return ResponseEntity.ok("Other Contributions Entity updated");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherContributionsEntityDTO> getOtherContributionsEntity(@PathVariable int id){
        return ResponseEntity.ok(otherContributionsEntityService.getOtherContributionsEntity(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OtherContributionsEntityDTO>> getAllOtherContributionsEntity(){
        return ResponseEntity.ok(otherContributionsEntityService.getAllOtherContributionsEntity());
    }
}
