package org.example.Controllers;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.example.Classes.EmployeeCareerPackage;
import org.example.Mappers.EmployeeCareerPackageDTO;
import org.example.Services.EmployeeCareerPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeCareerPackage")
public class EmployeeCareerPackageController {

    @Autowired
    private EmployeeCareerPackageService employeeCareerPackageService;

    @PostMapping
    public ResponseEntity<String> createEmployeeCareerPackage(@RequestBody EmployeeCareerPackageDTO employeeCareerPackageDTO){
        employeeCareerPackageService.createEmployeeCareerPackage(employeeCareerPackageDTO);
        return ResponseEntity.ok("Employee Career Package created.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployeeCareerPackage(@RequestBody int employeeId){
        employeeCareerPackageService.deleteEmployeeCareerPackage(employeeId);
        return ResponseEntity.ok("Employee Career Package deleted.");
    }

    @PutMapping
    public ResponseEntity<String> updateEmployeeCareerPackage(@RequestBody EmployeeCareerPackageDTO employeeCareerPackageDTO){
        employeeCareerPackageService.updateEmployeeCareerPackage(employeeCareerPackageDTO);
        return ResponseEntity.ok("Employee Career Package updated.");
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeCareerPackageDTO> getEmployeeCareerPackage(@PathVariable int employeeId){
        return ResponseEntity.ok(employeeCareerPackageService.getEmployeeCareerPackage(employeeId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeCareerPackageDTO>> getAllEmployeeCareerPackages(){
        return ResponseEntity.ok(employeeCareerPackageService.getAllEmployeeCareerPackages());
    }
}
