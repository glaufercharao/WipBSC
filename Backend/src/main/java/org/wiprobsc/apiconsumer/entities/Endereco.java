package org.wiprobsc.apiconsumer.entities;


import lombok.Data;

@Data
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private double frete;
    private boolean erro;
}
