package com.app.hospital.controller;

import com.app.hospital.entity.Medico;
import com.app.hospital.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping("/criarMedico")
    public ResponseEntity<String> createMedico(@RequestBody Medico medico) {
        try {
            String mensagem = this.medicoService.createMedico(medico);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateMedico/{crm}")
    public ResponseEntity<String> updateMedico(@RequestBody Medico medicoAtualizado, @PathVariable String crm) {
        try {
            String mensagem = this.medicoService.updateMedico(crm, medicoAtualizado);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteMedico/{crm}")
    public ResponseEntity<String> deleteMedico(@PathVariable String crm) {
        try {
            String mensagem = this.medicoService.deleteMedico(crm);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findMedicos")
    public ResponseEntity<List<Medico>> findTodosMedicos() {
        try {
            List<Medico> medicos = this.medicoService.findTodosMedicos();
            return new ResponseEntity<>(medicos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findMedicoCrm/{crm}")
    public ResponseEntity<Medico> findMedicoPorCrm(@PathVariable String crm) {
        try {
            Medico medico = this.medicoService.findPorCrm(crm);
            return new ResponseEntity<>(medico, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findMedicoEspecialidade/{especialidade}")
    public ResponseEntity<List<Medico>> findMedicoPorEspecialidade(@PathVariable String especialidade) {
        try {
            List<Medico> medicos = this.medicoService.findPorEspecialidade(especialidade);
            return new ResponseEntity<>(medicos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
