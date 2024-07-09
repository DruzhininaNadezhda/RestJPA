package com.example.restjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class ClientsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid",unique=true)
    @JoinColumn(name = "client_id")
    private Long clientid;
    @Column(name = "client_name", nullable = false)
    @JoinColumn(name = "client_name")
    private String clientName;
    @Column(name = "typeclient", nullable = false)
    @JoinColumn(name = "type_client")
   // @Enumerated(EnumType.STRING)
    private String typeclient;
    @Column(name = "datecreatclient", nullable = false)
    @JoinColumn(name = "date_creat_client")
    private Date datecreatclient;
    @OneToMany(mappedBy = "clientId", fetch = FetchType.LAZY)
    private Set<AddressesEntity> addressesEntities = new LinkedHashSet<>();
}
