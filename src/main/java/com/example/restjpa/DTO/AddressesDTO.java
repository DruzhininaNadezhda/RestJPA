package com.example.restjpa.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long client;
    @Pattern(regexp = "^([0-1][\\d][\\d].|2[0-4][\\d].|25[0-5].){3,3}([0-1][\\d][\\d]|2[0-4][\\d]|25[0-5])", message = "IP некорректный")
    private String ip;
    @JsonProperty(value = "address_id")
    private Long addressid;
    @Pattern(regexp = "([\\dA-Za-z]{1,2}-){5,5}([\\dA-Za-z]{1,2})", message = "MAC некорректный")
    private String mac;
    @NotBlank(message = "Модель не может быть пустой")
    private String model;
    @NotBlank(message = "Адрес не может быть пустым")
    private String address;
}

