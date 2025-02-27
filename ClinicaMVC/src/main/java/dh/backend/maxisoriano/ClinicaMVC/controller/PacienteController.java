package dh.backend.maxisoriano.ClinicaMVC.controller;

import dh.backend.maxisoriano.ClinicaMVC.model.Paciente;
import dh.backend.maxisoriano.ClinicaMVC.service.IPacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    public IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        Paciente pacienteARetornar = pacienteService.registrarPaciente(paciente);
        return pacienteARetornar;
    }
    @GetMapping
    public List<Paciente> buscarTodos(){
        return pacienteService.buscarTodos();
    }
    @GetMapping("/{id}")
    public Paciente buscarPacientePorId(@PathVariable Integer id){
        return pacienteService.buscarPorId(id);
    }
    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        pacienteService.actualizarPaciente(paciente);
        return "paciente actualizado";
    }
    @DeleteMapping("/{id}")
    public String borrarPaciente(@PathVariable Integer id){
        pacienteService.eliminarPaciente(id);
        return "paciente eliminado";
    }
}

