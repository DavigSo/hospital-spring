package com.app.hospital.service;

import com.app.hospital.entity.Medico;
import com.app.hospital.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public String createMedico(Medico medico) {
        if (medico != null && medico.getCrm() != null && !medico.getCrm().isEmpty() && !medico.getNome().isEmpty()) {
            medicoRepository.save(medico);
            return medico.getNome() + " foi salvo com sucesso!";
        }
        return "ERRO: informações incompletas ou inválidas.";
    }

    public String updateMedico(String crm, Medico medicoAtualizado) {
        Medico medico = findPorCrm(crm);
        if (medico != null) {
            medico.setNome(medicoAtualizado.getNome());
            medico.setEspecialidade(medicoAtualizado.getEspecialidade());
            medico.setSalario(medicoAtualizado.getSalario());
            medicoRepository.save(medico);
            return "Médico com CRM " + crm + " atualizado com sucesso.";
        }
        return "ERRO: Médico com CRM " + crm + " não encontrado.";
    }

    public Medico findPorCrm(String crm) {
        return medicoRepository.findByCrm(crm);
    }

    public List<Medico> findPorEspecialidade(String especialidade) {
        return medicoRepository.findByEspecialidade(especialidade);
    }

    public List<Medico> findTodosMedicos() {
        return medicoRepository.findAll();
    }

    public String deleteMedico(String crm) {
        Medico medico = findPorCrm(crm);
        if (medico != null) {
            medicoRepository.deleteByCrm(crm);
            return "Médico com CRM " + crm + " foi removido com sucesso.";
        }
        return "ERRO: Médico com CRM " + crm + " não encontrado.";
    }
}
