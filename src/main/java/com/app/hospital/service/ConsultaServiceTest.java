package com.app.hospital.service;

import com.app.hospital.entity.Consulta;
import com.app.hospital.entity.Medico;
import com.app.hospital.entity.Paciente;
import com.app.hospital.repository.ConsultaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConsultaServiceTest {

    @Mock
    private ConsultaRepository consultaRepository;

    @InjectMocks
    private ConsultaService consultaService;

    private Consulta consulta;

    @BeforeEach
    void setUp() {
        // Inicializar os mocks
        MockitoAnnotations.openMocks(this);

        // Criar uma consulta de exemplo
        Medico medico = new Medico();
        medico.setCrm("123456");

        Paciente paciente = new Paciente();
        paciente.setCpf("98765432100");

        consulta = new Consulta();
        consulta.setIdConsulta(1L);
        consulta.setDataHora(LocalDate.now());
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
    }

    @Test
    public void testMarcarConsulta() {
        // Simular o comportamento do repositório
        when(consultaRepository.save(consulta)).thenReturn(consulta);

        // Chamar o método de marcação de consulta
        Consulta consultaSalva = consultaService.marcarConsulta(consulta);

        // Verificar se a consulta foi marcada corretamente
        assertNotNull(consultaSalva);
        assertEquals(consulta.getIdConsulta(), consultaSalva.getIdConsulta());
        verify(consultaRepository, times(1)).save(consulta);
    }

    @Test
    public void testBuscarPorId() {
        // Simular que o repositório encontrou a consulta
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

        // Buscar a consulta pelo ID
        Consulta consultaEncontrada = consultaService.findConsultaId(1L);

        // Verificar se a consulta foi encontrada corretamente
        assertNotNull(consultaEncontrada);
        assertEquals(consulta.getIdConsulta(), consultaEncontrada.getIdConsulta());
        verify(consultaRepository, times(1)).findById(1L);
    }

    @Test
    public void testBuscarPorIdNaoEncontrado() {
        // Simular que o repositório não encontrou a consulta
        when(consultaRepository.findById(1L)).thenReturn(Optional.empty());

        // Buscar a consulta pelo ID
        Consulta consultaNaoEncontrada = consultaService.findConsultaId(1L);

        // Verificar se o retorno é null quando a consulta não é encontrada
        assertNull(consultaNaoEncontrada);
        verify(consultaRepository, times(1)).findById(1L);
    }
}
