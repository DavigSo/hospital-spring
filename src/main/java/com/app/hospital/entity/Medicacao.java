package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "medicacao")
public class  Medicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMedicamento;

    private LocalDate dataPrescricao;
    private String modoUso;
    private String nome;
    private String dosagem;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

}
