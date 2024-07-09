package com.example.restjpa.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientsAddressDTO {
    @JsonProperty(value = "client_id")
    private Long clientid;
    @JsonProperty(value = "client_name")
    @NotBlank(message = "Наименование не может быть пустым")
    @Pattern(regexp = "[а-яёА-ЯЁ, .-]{1,100}", message = "Наименование может содержать кириллицу, пробел или символы \",.-\"")
    private String clientName;
    @JsonProperty(value = "address_id")
    private Long addressid;
    @Pattern(regexp = "Юридическое лицо|Физическое лицо", message ="Тип не тот" )
    @JsonProperty(value = "type_name")
    private String typeclient;
    @JsonProperty(value = "date_creat_client")
    private Date datecreatclient;
    @JsonProperty(value = "ip")
    @NotBlank(message = "IP не может быть пустым")
    @Pattern(regexp = "^([0-1][\\d][\\d].|2[0-4][\\d].|25[0-5].){3,3}([0-1][\\d][\\d]|2[0-4][\\d]|25[0-5])", message = "IP некорректный")
    private String ip;
    @JsonProperty(value = "mac")
    @NotBlank(message = "MAC не может быть пустым")
    @Pattern(regexp = "([\\dA-Za-z]{1,2}-){5,5}([\\dA-Za-z]{1,2})", message = "MAC некорректный")
    private String mac;
    @JsonProperty(value = "model")
    @NotBlank(message = "Модель не может быть пустой")
    private String model;
    @JsonProperty(value = "address")
    @NotBlank(message = "Адрес не может быть пустым")
    private String address;
    @JsonProperty(value = "status")
    private String status;
    //private Set<ReferenceDTO> references;
    @JsonProperty(value = "addresses")
    private Set<AddressesDTO> addresses;
//    public String getTypeclient() {
//        if (typeclient==null){return null;}
//        return typeclient.getType();
//    }
//    public void setTypeclient(String typeclient) {
//        this.typeclient = TypeEnum.getType(typeclient);
//    }

}
