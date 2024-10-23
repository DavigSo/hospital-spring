package com.app.hospital.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

    private String bairro;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}
