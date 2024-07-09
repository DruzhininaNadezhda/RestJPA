package com.example.restjpa.controllers;

import com.example.restjpa.DTO.ClientsAddressDTO;
import com.example.restjpa.repository.ClientsRepo;
import com.example.restjpa.service.interfaces.AddressesService;
import com.example.restjpa.service.interfaces.ClientsAddressService;
import com.example.restjpa.service.interfaces.ClientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientsAddress")
public class ClientsAddressContr {
    private final ClientsAddressService clientsAddressService;
    private final AddressesService addressesService;
    private final ClientsService clientsService;
    private final ClientsRepo clientRepository;

    public ClientsAddressContr(ClientsAddressService clientsAddressService, AddressesService addressesService, ClientsService clientsService, ClientsRepo clientRepository) {
        this.clientsAddressService = clientsAddressService;
        this.addressesService = addressesService;
        this.clientsService = clientsService;
        this.clientRepository = clientRepository;
    }

    // private final ReferenceService referenceService; - прочитать
    //++++
    @GetMapping(value = "/client/{id}", produces = "application/json")
    public ResponseEntity<?> getClient(@PathVariable("id") Long id){
       if(clientsAddressService.findById(id)!=null) return ResponseEntity.ok(clientsAddressService.findById(id));
       else return ResponseEntity.ok().build();
   }
   //++++
    @GetMapping( produces = "application/json")
    public ResponseEntity<?> filter(@RequestParam String type, String name) {
        return ResponseEntity.ok(clientsAddressService.findFilter(type, name));
    }
    //+++
    @DeleteMapping("/{id}")
        public void removeById(@PathVariable("id") Long id) {
            clientsAddressService.remove(id);
        }
    //+++
        @PostMapping(consumes = "application/json")
    public ResponseEntity<?> creat(@RequestBody ClientsAddressDTO clientsAddress) {
            return getClient(clientsAddressService.create(clientsAddress));

    }
}
