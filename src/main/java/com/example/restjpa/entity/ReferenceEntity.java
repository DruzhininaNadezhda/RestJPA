package com.example.restjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reference")
public class ReferenceEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "referencenumber",unique=true)
    private Long referenceNumber;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "message", nullable = false)
    private String message;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client")
    private ClientsEntity clientId;
}
