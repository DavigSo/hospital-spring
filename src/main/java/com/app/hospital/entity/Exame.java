package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idExame;

    private LocalDate dataSolicitada;
    private String tipo;
    private String resultado;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

}
