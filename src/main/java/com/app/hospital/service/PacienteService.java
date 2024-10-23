package com.app.hospital.service;

import com.app.hospital.entity.Paciente;
import com.app.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    public String createPaciente(Paciente paciente) {

        if (paciente != null && !paciente.getCpf().isEmpty()) {
            pacienteRepository.save(paciente);
            return paciente.getNome() + "Paciente salvo com sucesso!";
        }
        return "ERRO: Paciente não encontrado";

    }

    public String updatePaciente(String cpf, Paciente pacienteAtualizado) {

        Paciente paciente = findByCpf(cpf);
        if(paciente != null) {

            paciente.setNome(pacienteAtualizado.getNome());
            paciente.setHistoricoMedico((pacienteAtualizado.getHistoricoMedico()));
            pacienteRepository.save(paciente);
            return "Medico com CPF " + cpf + " atualizado com sucesso.";
        }
        return "ERRO: Paciente não encontrado";

    }

    public Paciente findByCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public List<Paciente> findAllPacientes() {
        return pacienteRepository.findAll();
    }

    public String deletePaciente(String cpf) {
        Paciente paciente = findByCpf(cpf);
        if (paciente != null) {
            pacienteRepository.deleteByCpf(cpf);
            return "Paciente com CPF " + cpf + " foi removido com sucesso.";
        }
        return "ERRO: Médico com CPF " + cpf + " não encontrado.";
    }
}
