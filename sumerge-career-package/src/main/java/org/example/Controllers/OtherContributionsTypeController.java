package org.example.Controllers;

import org.example.Mappers.OtherContributionsTypeDTO;
import org.example.Services.OtherContributionsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otherContributionsTypes")
public class OtherContributionsTypeController {

    @Autowired
    private OtherContributionsTypeService otherContributionsTypeService;

    @PostMapping
    public ResponseEntity<String> createOtherContributionsType(@RequestBody OtherContributionsTypeDTO otherContributionsTypeDTO){
        otherContributionsTypeService.createOtherContributionsType(otherContributionsTypeDTO);
        return ResponseEntity.ok("Other Contributions type created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOtherContributionsType(@RequestBody int id){
        otherContributionsTypeService.deleteOtherContributionsType(id);
        return ResponseEntity.ok("Other Contributions type deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateOtherContributionsType(@RequestBody String description){
        otherContributionsTypeService.updateOtherContributionsType(description);
        return ResponseEntity.ok("Other Contributions type updated");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherContributionsTypeDTO> getOtherContributionsType(@PathVariable int id){
        return ResponseEntity.ok(otherContributionsTypeService.getOtherContributionsType(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OtherContributionsTypeDTO>> getAllOtherContributionsType(){
        return ResponseEntity.ok(otherContributionsTypeService.getAllOtherContributionsType());
    }
}
