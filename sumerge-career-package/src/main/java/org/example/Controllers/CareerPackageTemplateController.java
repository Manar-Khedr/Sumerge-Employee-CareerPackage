package org.example.Controllers;

import org.example.Mappers.CareerPackageTemplateDTO;
import org.example.Services.CareerPackageTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careerPackageTemplates")
public class CareerPackageTemplateController {

    @Autowired
    private CareerPackageTemplateService careerPackageTemplateService;

    @PostMapping
    public ResponseEntity<String> createCareerPackageTemplate(@RequestBody CareerPackageTemplateDTO careerPackageTemplateDTO){
        careerPackageTemplateService.createCareerPackageTemplate(careerPackageTemplateDTO);
        return ResponseEntity.ok("Career Package Template Created.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCareerPackage(@RequestBody int positionTitle){
        careerPackageTemplateService.deleteCareerPackage(positionTitle);
        return ResponseEntity.ok("Career Package Template Deleted.");
    }

    @PutMapping
    public ResponseEntity<String> updateCareerPackageTemplate(@RequestBody CareerPackageTemplateDTO careerPackageTemplateDTO){
        careerPackageTemplateService.updateCareerPackageTemplate(careerPackageTemplateDTO);
        return ResponseEntity.ok("Career Package Template Updated.");
    }

    @GetMapping("/{positionTitle}")
    public ResponseEntity<CareerPackageTemplateDTO> getCareerPackageTemplate(@PathVariable int positionTitle){
        return ResponseEntity.ok(careerPackageTemplateService.getCareerPackageTemplate(positionTitle));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CareerPackageTemplateDTO>> careerPackageTemplateDTOList(){
        return ResponseEntity.ok(careerPackageTemplateService.getCareerPackageTemplateDTOList());
    }
}
