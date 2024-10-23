package com.app.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "medico")
public class Medico extends Pessoa {

    @Id
    private String crm;

    private String especialidade;
    private double salario;


}
