package com.example.restjpa.controllers;

import com.example.restjpa.service.interfaces.ClientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/help")
@RequiredArgsConstructor
public class ReferenceContr {
    //private final ReferenceService referenceService;
    private final ClientsService clientsService;

//    @GetMapping(produces = "application/json")
//    public ResponseEntity<?> getRefenence(@RequestParam Long id) {
//        Optional<ReferenceDTO> reference = referenceService.findReferenceDtoById(id);
//        return ResponseEntity.ok(reference);
//    }
//    @PostMapping(consumes = "application/json")
//    public void help ( @RequestBody Optional<ReferenceDTO> reference){
//        clientsService.helpStarted(reference.get().getClientid());
//    }
}
