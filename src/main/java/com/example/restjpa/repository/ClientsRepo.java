package com.example.restjpa.repository;
import com.example.restjpa.entity.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClientsRepo extends JpaRepository<ClientsEntity, Long> {
    @Query("select p " +
            "from ClientsEntity p " +
            "join fetch p.addressesEntities  a" +
            " where (p.clientName like :name and p.typeclient= :type) " +
            "order by p.clientid")
    List<ClientsEntity> findAllFilter2(String name, String type);
    List<ClientsEntity> findAllByClientNameIsLikeIgnoreCaseAndTypeclientIsLikeIgnoreCase(String name, String type);
   @Query("select p " +
           "from AddressesEntity p " +
           "join fetch p.clientId  a" +
           " where (p.address like :name and a.typeclient= :type) or (a.clientName like :name and a.typeclient= :type)" +
           "order by a.clientid")
   List<ClientsEntity> findAllFilter20(String name, String type);
}
