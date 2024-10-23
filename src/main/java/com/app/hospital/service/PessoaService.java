package com.app.hospital.service;

import com.app.hospital.entity.Pessoa;
import com.app.hospital.repository.PessoaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRespository pessoaRespository;

    public String createPessoa(Pessoa pessoa) {
        if(pessoa != null && !pessoa.getNome().isEmpty()){
           this.pessoaRespository.save(pessoa);
           return pessoa.getNome() + "Pessoa salva com sucesso!";
        }
        return null;
    }
    public String updatePessoa(Pessoa pessoaAtualizada, long id) {

        Pessoa pessoa = findPessoaId(id);
        if (pessoa != null) {
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setEmail(pessoaAtualizada.getEmail());
            pessoa.setTelefone(pessoaAtualizada.getTelefone());
            pessoa.setEndereco(pessoaAtualizada.getEndereco());
            return pessoaRespository.save(pessoa) + "Pessoa atualizada com sucesso";
        }
        return null;
    }
    public String deletePessoa(Long id) {
        pessoaRespository.deleteById(id);
        return "Pessoa deletada com sucesso";
    }

    public List<Pessoa> findPessoas(){

        return this.pessoaRespository.findAll();

    }

    public Pessoa findPessoaId(Long id) {

        return pessoaRespository.findById(id).get();
    }




}
