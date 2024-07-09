package com.example.restjpa.service.interfaces;

import com.example.restjpa.DTO.AddressesDTO;
import com.example.restjpa.entity.AddressesEntity;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
public interface AddressesService {
    public Mono<AddressesDTO> findAddressesDtoById(long addressId);
    public Flux<AddressesDTO> findAll();
    public Mono<AddressesDTO> create(@Valid AddressesDTO dto);
    public Mono<AddressesDTO> update(@Valid AddressesDTO dto);
    public void remove(long id);
    public Flux<AddressesDTO> filerAddress(String address);
    public AddressesDTO addressConvertToDto(AddressesEntity entity);
    public AddressesEntity addressConvertToEntity(AddressesDTO dto);
}
