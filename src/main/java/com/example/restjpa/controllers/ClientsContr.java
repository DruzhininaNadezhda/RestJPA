package com.example.restjpa.controllers;

import com.example.restjpa.DTO.ClientsDTO;
import com.example.restjpa.service.interfaces.ClientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientsContr {
    private final ClientsService clientsService;

//    @PostMapping(value = "/help", consumes = "application/json")
//    public void help ( @RequestBody Optional<ReferenceDTO> reference){
//        clientsService.help(reference.get().getClientid());
//      referenceService.help(reference);
//     }
    @PatchMapping()
    public Mono<ClientsDTO> update(@RequestBody ClientsDTO clientsDTO) {
        return clientsService.update(clientsDTO);
    }
    @GetMapping(value = "/client/{id}", produces = "application/json")
    public ResponseEntity<?> getClient(@PathVariable("id") Long id){
        if(clientsService.findById(id)!=null) return ResponseEntity.ok(clientsService.findById(id));
        else return ResponseEntity.ok().build();
    }
}
