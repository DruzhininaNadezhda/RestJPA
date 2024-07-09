package com.example.restjpa.service.impl;

import com.example.restjpa.DTO.AddressesDTO;
import com.example.restjpa.entity.AddressesEntity;
import com.example.restjpa.repository.AddressRepo;
import com.example.restjpa.repository.ClientsRepo;
import com.example.restjpa.service.interfaces.AddressesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

@Service
@Validated
public class AddressesServiceImpl implements AddressesService {
    private final AddressRepo addressRepository;
    private final ClientsRepo clientsRepo;


    public AddressesServiceImpl(AddressRepo addressRepository, ClientsRepo clientsRepo) {
        this.addressRepository = addressRepository;
        this.clientsRepo = clientsRepo;
    }
    @Override
    public Mono<AddressesDTO> findAddressesDtoById(long addressId) {
        return Mono.justOrEmpty(addressRepository.findById(addressId)).map(h-> addressConvertToDto(h));
    }
//    @Override
//    public Flux<AddressesDTO> findAddressesDtoBClientId(Long id) {
//       return Flux.fromIterable(addressRepository.findAllByClientIsLike(id)).map(h-> addressConvertToDto(h));
//    }

    @Override
    public Flux<AddressesDTO> findAll() {                                 //настроить нормально маппер!!!!!!!!!!!!!
        return Flux.fromIterable(addressRepository.findAll()).map(entity -> {
                            Long client = entity.getClientId().getClientid();
                           return AddressesDTO.builder()
                                    .client(client != null ? client : 0)
                                    .addressid(entity.getAddressid())
                                    .ip(entity.getIp())
                                    .mac(entity.getMac())
                                   .model(entity.getModel())
                                  .address(entity.getAddress())
                                   .build();
                        }
                );
    }
    @Transactional
    @Override
    public Mono<AddressesDTO> create(AddressesDTO dto) {
        if(dto!=null){
                return Mono.just(addressRepository.save(addressConvertToEntity(dto))).map(h-> addressConvertToDto(h));
        }
        return Mono.empty();
    }
    @Transactional
    //@Modifying //блокирует доступ других пользователей
    //@Query("UPDATE address SET ip=:ip WHERE id=:id")
    @Override
    public Mono<AddressesDTO> update(AddressesDTO dto) {
        if(dto!=null){
            return Mono.just(addressRepository.save(addressConvertToEntity(dto))).map(h-> addressConvertToDto(h));
        }
        return Mono.empty();
    }
    @Transactional
    @Override
    public void remove(long id) {
        Optional<AddressesEntity> addressBd = addressRepository.findById(id);
        addressRepository.delete(addressBd.get());
    }
    @Override
    public AddressesDTO addressConvertToDto(AddressesEntity entity){ // совсем не работает маппер, срочно разобраться с получением лонга из объекта клиента
        return AddressesDTO.builder()
                .client(entity.getClientId().getClientid())
                .address(entity.getAddress())
                .ip(entity.getIp())
                .mac(entity.getMac())
                .model(entity.getModel())
                .addressid(entity.getAddressid())
                .build();
    }
    @Override
    public AddressesEntity addressConvertToEntity(AddressesDTO dto){
        return Objects.isNull(dto)? null: AddressesEntity.builder()
                .ip(dto.getIp())
                .address(dto.getAddress())
                .mac(dto.getMac())
                .model(dto.getModel())
                .addressid(dto.getAddressid())
                .clientId(clientsRepo.findById(dto.getClient()).get())
                .build();
    }
    @Transactional
    @Override
    public Flux<AddressesDTO> filerAddress(String address){
        String a="%"+address+"%";
        return Flux.fromIterable(addressRepository.findAddress(a)).map(this::addressConvertToDto);
    }
}