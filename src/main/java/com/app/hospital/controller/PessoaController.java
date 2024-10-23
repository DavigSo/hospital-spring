package com.app.hospital.controller;

import com.app.hospital.entity.Pessoa;
import com.app.hospital.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/createPessoa")
    public ResponseEntity<String> createPessoa(@RequestBody Pessoa pessoa) {

        try {

            String mensagem = this.pessoaService.createPessoa(pessoa);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updatePessoa/{id}")
    public ResponseEntity<String> updatePessoa(@RequestBody Pessoa pessoa, @PathVariable long id) {

        try {
            String mensagem = this.pessoaService.updatePessoa(pessoa, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e){

            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/findPessoas")
    public ResponseEntity<List<Pessoa>> findPessoas() {

        try {

            List<Pessoa> pessoa =  this.pessoaService.findPessoas();
            return new ResponseEntity<>(pessoa, HttpStatus.OK);

        } catch (Exception e) {

            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findPessoaId/{id}")
    public ResponseEntity<Pessoa> findPessoaId(@PathVariable("id") long id) {
        try {

            Pessoa pessoa = this.pessoaService.findPessoaId(id);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deletePessoa/{id}")
    public ResponseEntity<String> deletePessoa(@RequestBody long id) {

        try {

            String mensagem = this.pessoaService.deletePessoa(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
