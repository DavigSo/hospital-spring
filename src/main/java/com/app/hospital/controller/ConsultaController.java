package com.app.hospital.controller;

import com.app.hospital.entity.Consulta;
import com.app.hospital.entity.Pessoa;
import com.app.hospital.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/createConsulta")
    public ResponseEntity<String> createConsulta(@RequestBody Consulta consulta) {

        try {

            String mensagem = this.consultaService.createConsulta(consulta);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findConsultaId/{id}")
    public ResponseEntity<Consulta> findConsultaId(@RequestBody long id) {
        try {

            Consulta consulta = this.consultaService.findConsultaId(id);
            return new ResponseEntity<>(consulta, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarTodasConsultas")
    public ResponseEntity<List<Consulta>> listarTodasConsultas() {

        try {

            List<Consulta> consultas =  this.consultaService.listarTodasConsultas();
            return new ResponseEntity<>(consultas, HttpStatus.OK);

        } catch (Exception e) {

            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarPorMedico/{crm}")
    public ResponseEntity<Consulta> findByMedicoCrm(@RequestBody String crm) {
        try {

            Consulta consultasMedico = (Consulta) this.consultaService.findByMedicoCrm(crm);
            return new ResponseEntity<>(consultasMedico, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByPacienteCpf/{cpf}")
    public ResponseEntity<Consulta> findByPacienteCpf(@RequestBody String cpf) {
        try {

            Consulta consultasPaciente = (Consulta) this.consultaService.findByPacienteCpf(cpf);
            return new ResponseEntity<>(consultasPaciente, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteConsulta/{id}")
    public ResponseEntity<String> deleteConsulta(@RequestBody long id) {

        try {

            String mensagem = this.consultaService.deleteConsulta(id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
