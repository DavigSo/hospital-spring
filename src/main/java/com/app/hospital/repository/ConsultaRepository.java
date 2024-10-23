package com.app.hospital.repository;

import com.app.hospital.entity.Consulta;
import com.app.hospital.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByMedicoCrm(String crm);

    List<Consulta>findByPacienteCpf(String cpf);
}
