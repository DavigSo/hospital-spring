package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idConsulta;

    private LocalDate dataHora;

    @ManyToOne
    @JoinColumn(name = "medico_crm")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_cpf")
    private Paciente paciente;

    @OneToOne(mappedBy = "consulta")
    private Diagnostico diagnostico;

    @OneToMany(mappedBy = "consulta")
    private List<Exame> exames;

    @OneToMany(mappedBy = "consulta")
    private List<Medicacao> medicacoes;

}
