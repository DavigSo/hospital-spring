package com.app.hospital.service;

import com.app.hospital.entity.Exame;
import com.app.hospital.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;


    public String registrarExame(Exame exame) {
        if (exame.getConsulta() != null) {
            exameRepository.save(exame);
            return "Exame registrado com sucesso!";
        }
        return "Erro ao registrar exame: consulta associada é obrigatória.";
    }


    public String atualizarExame(Long id, Exame novoExame) {
        Optional<Exame> exameOptional = exameRepository.findById(id);
        if (exameOptional.isPresent()) {
            Exame exame = exameOptional.get();
            exame.setDataSolicitada(novoExame.getDataSolicitada());
            exame.setTipo(novoExame.getTipo());
            exame.setResultado(novoExame.getResultado());
            exameRepository.save(exame);
            return "Exame atualizado com sucesso!";
        }
        return "Exame não encontrado.";
    }


    public List<Exame> listarTodos() {
        return exameRepository.findAll();
    }

    public List<Exame> listarPorConsulta(Long consultaId) {
        return exameRepository.findByConsultaId(consultaId);
    }


    public String excluirExame(Long id) {
        if (exameRepository.existsById(id)) {
            exameRepository.deleteById(id);
            return "Exame excluído com sucesso!";
        }
        return "Exame não encontrado.";
    }
}
