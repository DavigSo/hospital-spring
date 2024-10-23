package com.app.hospital.controller;

import com.app.hospital.entity.Paciente;
import com.app.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/criarPaciente")
    public ResponseEntity<String> createPaciente(@RequestBody Paciente paciente) {
       try {
           String mensagem = this.pacienteService.createPaciente(paciente);
           return new ResponseEntity<>(mensagem, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
    }

    @PutMapping("/updatePaciente/{cpf}")
    public ResponseEntity<String> updatePaciente(@PathVariable String cpf, @RequestBody Paciente pacienteAtualizado) {

        try {
            String mensagem = pacienteService.updatePaciente(cpf, pacienteAtualizado);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findPacientes")
    public ResponseEntity<List<Paciente>> listarPacientes() {

        try {
            List<Paciente> pacientes = this.pacienteService.findAllPacientes();
            return new ResponseEntity<>(pacientes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findPaciente/{cpf}")
    public ResponseEntity<Paciente> findPaciente(@PathVariable String cpf) {
        try {
            Paciente paciente = pacienteService.findByCpf(cpf);
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletePaciente/{cpf}")
    public ResponseEntity<String> deletePaciente(@PathVariable String cpf) {
        try {
            String mensagem = this.pacienteService.deletePaciente(cpf);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
}
