package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente  extends  Pessoa{

    @Id
    private String cpf;
    private String historicoMedico;

}
