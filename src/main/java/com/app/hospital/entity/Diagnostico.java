package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDiagnostico;

    private String patologia;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;
}
