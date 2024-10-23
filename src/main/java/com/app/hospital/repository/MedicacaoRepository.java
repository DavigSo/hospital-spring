package com.app.hospital.repository;

import com.app.hospital.entity.Medicacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicacaoRepository extends JpaRepository<Medicacao, Long> {

    List<Medicacao> findByConsultaId(Long consultaId);
}
