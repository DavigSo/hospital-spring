package com.app.hospital.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPessoa;

    private String nome;
    private String email;

    @ElementCollection
    @CollectionTable(name = "telefone", joinColumns = @JoinColumn(name = "pessoa_id"))
    private List<String> telefone;

    @Embedded
    private Endereco endereco;
}
