package com.app.hospital.service;

import com.app.hospital.entity.Consulta;
import com.app.hospital.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public String createConsulta(Consulta consulta) {
        if(consulta.getMedico() != null && consulta.getPaciente() != null) {

            consultaRepository.save(consulta);
            return "Consulta registrada com sucesso!";
        }

        return "Erro ao registrar consulta: médico e paciente são obrigatórios.";
    }

    public Consulta findConsultaId(Long id) {
        return consultaRepository.findById(id).get();
    }
    public Consulta marcarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarTodasConsultas() {
        return consultaRepository.findAll();
    }

    public List<Consulta> findByMedicoCrm(String crm) {
        return consultaRepository.findByMedicoCrm(crm);
    }

    public List<Consulta> findByPacienteCpf(String cpf) {
        return consultaRepository.findByPacienteCpf(cpf);
    }

    public String deleteConsulta(Long id) {
        if(consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return "Consulta excluída com sucesso!";
        }
        return "Consulta não encontrada.";
    }
}
