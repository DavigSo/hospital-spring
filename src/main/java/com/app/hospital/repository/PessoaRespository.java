package com.app.hospital.repository;

import com.app.hospital.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRespository extends JpaRepository<Pessoa, Long> {

    //Optional<Pessoa> findByCpf(String, cpf)
}
