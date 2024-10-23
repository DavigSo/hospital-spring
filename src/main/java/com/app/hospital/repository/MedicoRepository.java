package com.app.hospital.repository;

import com.app.hospital.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico findByCrm(String crm);

    @Query("FROM Medico m WHERE m.especialidade = :especialidade")
    List<Medico> findByEspecialidade(String especialidade);

    void deleteByCrm(String crm);
}

