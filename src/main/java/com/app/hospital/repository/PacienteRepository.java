package com.app.hospital.repository;

import com.app.hospital.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    Paciente findByCpf(String cpf);

    void deleteByCpf(String crm);
}
