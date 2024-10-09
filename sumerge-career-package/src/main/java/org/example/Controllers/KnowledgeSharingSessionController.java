package org.example.Controllers;

import org.example.Mappers.KnowledgeSharingSessionDTO;
import org.example.Services.KnowledgeSharingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knowledgeSharingSessions")
public class KnowledgeSharingSessionController {

    @Autowired
    private KnowledgeSharingSessionService knowledgeSharingSessionService;

    @PostMapping
    public ResponseEntity<String> createKnowledgeSharingSession(@RequestBody KnowledgeSharingSessionDTO knowledgeSharingSessionDTO){
        knowledgeSharingSessionService.createKnowledgeSharingSession(knowledgeSharingSessionDTO);
        return ResponseEntity.ok("Knowledge Sharing Session created");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteKnowledgeSharingSession(@RequestBody String topic){
        knowledgeSharingSessionService.deleteKnowledgeSharingSession(topic);
        return ResponseEntity.ok("Knowledge Sharing Session deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateKnowledgeSharingSession(@RequestBody KnowledgeSharingSessionDTO knowledgeSharingSessionDTO){
        knowledgeSharingSessionService.updateKnowledgeSharingSession(knowledgeSharingSessionDTO);
        return ResponseEntity.ok("Knowledge Sharing Session updated");
    }

    @GetMapping("/{topic}")
    public ResponseEntity<KnowledgeSharingSessionDTO> getKnowledgeSharingSession(@PathVariable String topic){
        return ResponseEntity.ok(knowledgeSharingSessionService.getKnowledgeSharingSession(topic));
    }

    @GetMapping
    public ResponseEntity<List<KnowledgeSharingSessionDTO>> getAllKnowledgeSharingSession(){
        return ResponseEntity.ok(knowledgeSharingSessionService.getAllKnowledgeSharingSession());
    }

}
