package com.example.restjpa.service;


/*import com.example.springj310.dto.AddressesDTO;
import com.example.springj310.dto.ClientsAddressDTO;
import com.example.springj310.dto.ClientsDTO;
import com.example.springj310.entity.AddressesEntity;
import com.example.springj310.entity.ClientsEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ConvertMapper {
    @Autowired
    private ObjectMapper mapper;
    private final ModelMapper modelMapper;
    public Converters() {
        this.modelMapper = new ModelMapper();


        public class ConvertMapper {
    // public ClientsAddressDTO addressClientConvertToDto(ClientsEntity entity2, AddressesEntity entity) {
    //   ClientsAddressDTO clientsAddressDTO = new ClientsAddressDTO();
    //   if (entity == null)
    //   {return clientsAddressDTO.builder()
    //           .clientid(clientConvertToDto(entity2).getClientid())
    //           .datecreatclient(clientConvertToDto(entity2).getDatecreatclient())
    //           .clientName(clientConvertToDto(entity2).getClientName())
    //           .typeclient(clientConvertToDto(entity2).getTypeclient())
    //           .addressid(-99999999999999l)
    //           .build();}
    //   return clientsAddressDTO.builder()
    //           .addressid(addressConvertToDto(entity).getAddressid())
    //            .clientid(clientConvertToDto(entity2).getClientid())
    //           .datecreatclient(clientConvertToDto(entity2).getDatecreatclient())
    //           .clientName(clientConvertToDto(entity2).getClientName())
    //            .typeclient(clientConvertToDto(entity2).getTypeclient())
    //             .model(addressConvertToDto(entity).getModel())
    //            .address(addressConvertToDto(entity).getAddress())
    //             .ip(addressConvertToDto(entity).getIp())
    //             .mac(addressConvertToDto(entity).getMac())
    //             .build();
    //  }
}
        /*public Converters() {
        this.modelMapper = new ModelMapper();
//modelMapper.createTypeMap(ClientsEntity.class, ClientsAddressDTO.class)
        // .addMapping(ClientsEntity::getAddressEntities, ClientsAddressDTO::setAddresses);
        modelMapper.createTypeMap(AddressesEntity.class, ClientsAddressDTO.class)
                .addMapping(AddressesEntity::getModel,ClientsAddressDTO::setModel)
                .addMapping(AddressesEntity::getAddress,ClientsAddressDTO::setAddress)
                .addMapping(AddressesEntity::getIp,ClientsAddressDTO::setIp);
    }
    public ClientsAddressDTO addressClientConvertToDto(ClientsEntity entity){
        return modelMapper.map(entity, ClientsAddressDTO.class);
    }*/
