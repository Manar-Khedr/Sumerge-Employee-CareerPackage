package org.example.Controllers;

import org.example.Mappers.ExperienceProfileDTO;
import org.example.Services.ExperienceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experienceProfiles")
public class ExperienceProfileController {

    @Autowired
    private ExperienceProfileService experienceProfileService;

    @PostMapping
    public ResponseEntity<String> createExperienceProfile(@RequestBody ExperienceProfileDTO experienceProfileDTO){
        experienceProfileService.createExperienceProfile(experienceProfileDTO);
        return ResponseEntity.ok("Experience Profile Created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteExperienceProfile(@RequestBody int id){
        experienceProfileService.deleteExperienceProfile(id);
        return ResponseEntity.ok("Experience Profile deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateExperienceProfile(@RequestBody ExperienceProfileDTO experienceProfileDTO){
        experienceProfileService.updateExperienceProfile(experienceProfileDTO);
        return ResponseEntity.ok("Experience Profile updated");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceProfileDTO> getExperienceProfile(@PathVariable int id){
        return ResponseEntity.ok(experienceProfileService.getExperienceProfile(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExperienceProfileDTO>> getAllExperienceProfile(){
        return ResponseEntity.ok(experienceProfileService.getAllExperienceProfile());
    }

}
