package com.app.hospital.controller;

import com.app.hospital.entity.Medicacao;
import com.app.hospital.entity.Pessoa;
import com.app.hospital.service.MedicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicacao")
public class MedicacaoController {

    @Autowired
    private MedicacaoService medicacaoService;

    @PostMapping("/registrarMedicacao")
    public ResponseEntity<String> registrarMedicacao(@RequestBody Medicacao medicacao) {

        try {

            String mensagem = this.medicacaoService.registrarMedicacao(medicacao);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/updateMedicacao/{id}")
    public ResponseEntity<String> updateMedicacao(@PathVariable long id, @RequestBody Medicacao medicacao) {

        try {
            String mensagem = this.medicacaoService.updateMedicacao(id, medicacao);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e){

            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findMedicacoes")
    public ResponseEntity<List<Medicacao>> findAll() {

        try {

            List<Medicacao> medicacao =  this.medicacaoService.findAll();
            return new ResponseEntity<>(medicacao, HttpStatus.OK);

        } catch (Exception e) {

            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarPorConsultaId/{id}")
    public ResponseEntity<List<Medicacao>> listarPorConsultaId(@PathVariable("id") long consultaId) {
        try {
            List<Medicacao> medicacao = this.medicacaoService.listarPorConsultaId(consultaId);
            return new ResponseEntity<>(medicacao, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteMedicacao/{id}")
    public ResponseEntity<String> deleteMedicacao(@RequestBody long id) {

        try {

            String mensagem = this.medicacaoService.deleteMedicacao(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
