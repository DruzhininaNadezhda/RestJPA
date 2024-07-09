package com.example.restjpa.repository;
import com.example.restjpa.entity.AddressesEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AddressRepo extends ListCrudRepository<AddressesEntity, Long> {
    //@Query("select p from AddressesEntity p where p.address like :address")
    //List<AddressesEntity> findAllByAddressIsLikeIgnoreCase(String address);
    @Query("select p " +
            "from AddressesEntity p " +
            "join fetch p.clientId c" +
            " where p.address like :address")
    List<AddressesEntity> findAddress(String address);
}
