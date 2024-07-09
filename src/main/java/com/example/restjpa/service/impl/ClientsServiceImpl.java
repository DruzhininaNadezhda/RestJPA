package com.example.restjpa.service.impl;

import com.example.restjpa.DTO.AddressesDTO;
import com.example.restjpa.DTO.ClientsAddressDTO;
import com.example.restjpa.DTO.ClientsDTO;
import com.example.restjpa.entity.AddressesEntity;
import com.example.restjpa.entity.ClientsEntity;
import com.example.restjpa.repository.ClientsRepo;
import com.example.restjpa.service.interfaces.ClientsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class ClientsServiceImpl implements ClientsService {
    private final ClientsRepo clientRepository;
    public ClientsServiceImpl(ClientsRepo clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Flux<ClientsDTO> findAll(){
        return Flux.fromIterable(clientRepository.findAll())
                .map(ClientsService::clientConvertToDto);
    }
    @Transactional
    @Override
    public Mono<ClientsDTO> update(ClientsDTO dto){
        if(dto!=null){
            return Mono.just(clientRepository.save(convertToEntity(dto)))
                    .map(ClientsService::clientConvertToDto);
        }return Mono.empty();
    }
    @Transactional
    @Override
    public Optional<ClientsDTO> create(ClientsEntity entity) {
        return Optional.of(clientRepository.save(entity)).map(ClientsService::clientConvertToDto);
    }
    @Transactional
    @Override
    public Optional<ClientsDTO> findClientsDtoById(long clientID) {
        return Optional.of(clientRepository.findById(clientID).get()).map(ClientsService::clientConvertToDto);
    }
    @Transactional
    @Override
    public Flux<ClientsDTO> filerTypeName(String type1, String name1){
        String name = "%"+ name1+"%";
        String type = "%"+ type1+"%";
        return Flux.fromIterable(clientRepository
                .findAllByClientNameIsLikeIgnoreCaseAndTypeclientIsLikeIgnoreCase(name,type))
                .map(ClientsService::clientConvertToDto);
    }

    @Transactional
    @Override
    public void remove(long id) {
            Optional<ClientsEntity> addressBd = clientRepository.findById(id);
            clientRepository.delete(addressBd.get());
        }

    @Override
    public ClientsEntity convertToEntity(ClientsDTO dto) {
       return ClientsEntity.builder()
               .clientName(dto.getClientName())
               .clientid(dto.getClientid())
               .datecreatclient(dto.getDatecreatclient())
               .typeclient(dto.getTypeclient()).build();
    }
    @Override
    @Transactional
    public Mono<ClientsDTO> findById(Long id){
        ClientsEntity result =  clientRepository.findById(id).orElse(null);
        return Mono.justOrEmpty(ClientsService.clientConvertToDto(result));
    }
    //@Override
    //public void help (Long id){
        //clientRepository.help(id);
//}
   // @Override
    //public void helpStarted (Long id){
      //  clientRepository.helpStarted(id);
    }
