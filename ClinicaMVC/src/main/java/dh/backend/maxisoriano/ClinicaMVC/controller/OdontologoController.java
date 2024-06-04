package dh.backend.maxisoriano.ClinicaMVC.controller;

import dh.backend.maxisoriano.ClinicaMVC.model.Odontologo;
import dh.backend.maxisoriano.ClinicaMVC.model.Paciente;
import dh.backend.maxisoriano.ClinicaMVC.service.IOdontologoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    public IOdontologoService odontologoService;
    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @PostMapping
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo odontologoARetornar = odontologoService.registrarOdontologo(odontologo);
        return odontologoARetornar;
    }
    @GetMapping
    public List<Odontologo> buscarTodos(){
        return odontologoService.buscarTodos();
    }
    @GetMapping("/{id}")
    public Odontologo buscarOdontologoPorId(@PathVariable Integer id){
        return odontologoService.buscarPorId(id);
    }
    @PutMapping
    public String actualizarOdontologo(@RequestBody Odontologo odontologo){
        odontologoService.actualizarOdontologo(odontologo);
        return "Odontologo actualizado";
    }
    @DeleteMapping("/{id}")
    public String borrarOdontologo(@PathVariable Integer id){
        odontologoService.eliminarOdontologo(id);
        return " eliminado";
    }
}
