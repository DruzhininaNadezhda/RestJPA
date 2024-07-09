package com.example.restjpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class AddressesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addressid",unique=true)
    @JoinColumn(name = "address_id")
    private Long addressid;

    @Column(name = "ip", nullable = false)
    @JoinColumn(name = "ip")
    private String ip;

    @Column(name = "mac", nullable = false)
    @JoinColumn(name = "mac")
    private String mac;
    @Column(name = "model", nullable = false)
    @JoinColumn(name = "model")
    private String model;

    @Column(name = "address", nullable = false)
    @JoinColumn(name = "address")
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    private ClientsEntity clientId;

}
