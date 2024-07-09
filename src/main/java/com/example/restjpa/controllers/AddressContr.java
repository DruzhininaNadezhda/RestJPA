package com.example.restjpa.controllers;

import com.example.restjpa.DTO.AddressesDTO;
import com.example.restjpa.entity.AddressesEntity;
import com.example.restjpa.service.interfaces.AddressesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressContr {
    private final AddressesService addressesService;
    @DeleteMapping("/{id}")
    public void removeById(@PathVariable("id") Long id) {
        addressesService.remove(id);
    }
    @PostMapping
    public Mono<AddressesDTO> create (@RequestBody AddressesDTO addresses){
       return addressesService.create(addresses);
    }
    @PatchMapping
    public Mono<AddressesDTO> update (@RequestBody AddressesDTO addresses){
        return addressesService.update(addresses);
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getAddress(@PathVariable Long id){
         return ResponseEntity.ok(addressesService.findAddressesDtoById(id));
    }
}
