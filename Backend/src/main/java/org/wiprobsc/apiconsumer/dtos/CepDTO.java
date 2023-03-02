package org.wiprobsc.apiconsumer.dtos;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class CepDTO {
    @Pattern(regexp = ("(\\d{5}-\\d{3})"), message = "Formato de CEP inválido.")
    private String cep;
}
