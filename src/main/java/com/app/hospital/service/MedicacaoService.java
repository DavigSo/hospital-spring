package com.app.hospital.service;

import com.app.hospital.entity.Consulta;
import com.app.hospital.entity.Medicacao;
import com.app.hospital.repository.MedicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicacaoService {

    @Autowired
    private MedicacaoRepository medicacaoRepository;

    public String registrarMedicacao(Medicacao medicacao) {
        if (medicacao.getNome() != null && !medicacao.getNome().isEmpty() &&
        medicacao.getDosagem() != null && !medicacao.getDosagem().isEmpty()) {
            medicacaoRepository.save(medicacao);
            return "Medicação registrada com sucesso!";
        }
        return "Dados insuficientes para registrar a medicação.";
    }

    public String updateMedicacao(Long id, Medicacao novaMedicacao) {
        Optional<Medicacao> medicacaoOptional = medicacaoRepository.findById(id);
        if(medicacaoOptional.isPresent()) {
            Medicacao medicacao = medicacaoOptional.get();
            medicacao.setNome(novaMedicacao.getNome());
            medicacao.setDosagem(novaMedicacao.getDosagem());
            medicacao.setModoUso(novaMedicacao.getModoUso());
            medicacao.setDataPrescricao(novaMedicacao.getDataPrescricao());
            medicacaoRepository.save(medicacao);
            return "Medicação atualizada com sucesso!";

        }

        return "Medicação não encontrada.";
    }

    public List<Medicacao> findAll(){
        return medicacaoRepository.findAll();
    }

    public List<Medicacao> listarPorConsultaId(Long consultaId) {
        return medicacaoRepository.findByConsultaId(consultaId);
    }

    public String deleteMedicacao(Long id) {
        if(medicacaoRepository.existsById(id)) {
            medicacaoRepository.deleteById(id);
            return "Medicação excluída com sucesso!";
        }
        return "Medicação não encontrada.";
    }

}
