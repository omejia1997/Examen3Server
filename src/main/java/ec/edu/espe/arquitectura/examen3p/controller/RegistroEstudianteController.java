/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package ec.edu.espe.arquitectura.examen3p.controller;

import ec.edu.espe.arquitectura.examen3p.dto.RegistroEstudianteRQ;
import ec.edu.espe.arquitectura.examen3p.model.RegistroEstudiante;
import ec.edu.espe.arquitectura.examen3p.service.RegistroEstudianteService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/registroEstudiante")
public class RegistroEstudianteController {

    private final RegistroEstudianteService registroEstudianteService;

    public RegistroEstudianteController(RegistroEstudianteService registroEstudianteService) {
        this.registroEstudianteService = registroEstudianteService;
    }

 
    @GetMapping(value = "{paralelo}/{nivel}")
    public ResponseEntity getRegistrosEstudianteByParaleloAndNivel(@PathVariable("paralelo") String paralelo, @PathVariable("nivel") Integer nivel) {
        log.info(" paralelo: {}, nivel: {}", paralelo, nivel);
        try {
             List<RegistroEstudiante> registroEstudiante = this.registroEstudianteService.findByParaleloAndNivel(paralelo, nivel);
            return ResponseEntity.ok(registroEstudiante);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping(value = "{nivel}")
    public ResponseEntity getRegistrosEstudianteByNivel(@PathVariable("nivel") Integer nivel) {
        log.info(" nivel {}", nivel);
        try {
             List<RegistroEstudiante> registroEstudiante = this.registroEstudianteService.findByNivel(nivel);
            return ResponseEntity.ok(registroEstudiante);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity saveWithParalelo(@RequestBody RegistroEstudianteRQ registroEstudianteRQ) {
        log.info("Registro de materia a crear: {}", registroEstudianteRQ);
        try {
            this.registroEstudianteService.saveWithRegistroEstudiante(registroEstudianteRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
