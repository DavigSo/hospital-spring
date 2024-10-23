package com.app.hospital.repository;

import com.app.hospital.entity.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExameRepository extends JpaRepository<Exame, Long> {

    List<Exame> findByConsultaId(Long consultaId);
}
