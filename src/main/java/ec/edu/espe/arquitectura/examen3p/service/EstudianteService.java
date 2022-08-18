/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package ec.edu.espe.arquitectura.examen3p.service;


import ec.edu.espe.arquitectura.examen3p.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.examen3p.dao.RegistroEstudianteRepository;
import ec.edu.espe.arquitectura.examen3p.dto.EstudianteRQ;
import ec.edu.espe.arquitectura.examen3p.model.Estudiante;
import ec.edu.espe.arquitectura.examen3p.model.RegistroEstudiante;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EstudianteService {

    EstudianteRepository estudianteRepo;
    RegistroEstudianteRepository registroEstudianteRepo;

    public EstudianteService(EstudianteRepository estudianteRepo, RegistroEstudianteRepository registroEstudianteRepo) {
        this.estudianteRepo = estudianteRepo;
        this.registroEstudianteRepo = registroEstudianteRepo;
    }

    public Estudiante findByCedula(String cedula) throws Exception {
        Estudiante estudiante = this.estudianteRepo.findByCedula(cedula);

        if (!(estudiante == null)) {
            throw new Exception("No se ha encontrado el estudiante con la cedula ingresada");
        }

        return estudiante;
    }
    
    public void saveEstudiante(EstudianteRQ estudianteRQ) throws Exception {

        if (this.estudianteRepo.existsByCedula(estudianteRQ.getCedula())) {
            throw new Exception("Ya existe el mismo estudiante con la cedula que ingreso");
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setCedula(estudianteRQ.getCedula());
        estudiante.setNombres(estudianteRQ.getNombres());
        estudiante.setApellidos(estudianteRQ.getApellidos());
        
        RegistroEstudiante registroEstudiante = new RegistroEstudiante();
        
        registroEstudiante.setNivel(estudianteRQ.getNivel());
        registroEstudiante.setEstudiante(this.estudianteRepo.save(estudiante));
        
        this.registroEstudianteRepo.save(registroEstudiante);

    }
}
