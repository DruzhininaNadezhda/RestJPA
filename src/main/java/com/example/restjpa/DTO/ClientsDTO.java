package com.example.restjpa.DTO;

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
public class ClientsDTO {
    private Long clientid;
    @Pattern(regexp = "[а-яёА-ЯЁ, .-]{1,100}", message = "Наименование может содержать кириллицу, пробел или символы \",.-\"")
    private String clientName;
    //@Pattern(regexp = "Юридическое лицо \\|Физическое лицо", message ="Тип не тот" )
    private TypeEnum typeclient;
    private Date datecreatclient;
    private Set<AddressesDTO> addresses;
    //private Set<ReferenceDTO> references;
    private String status;
    public String getTypeclient() {
        if (typeclient==null){return null;}
        return typeclient.getType();
    }
    public void setTypeclient(String typeclient) {
        this.typeclient = TypeEnum.getType(typeclient);
    }
}
