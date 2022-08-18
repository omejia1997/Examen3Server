/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package ec.edu.espe.arquitectura.examen3p.dao;

import ec.edu.espe.arquitectura.examen3p.model.Estudiante;
import ec.edu.espe.arquitectura.examen3p.model.RegistroEstudiante;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistroEstudianteRepository extends MongoRepository<RegistroEstudiante, String> {

    List<RegistroEstudiante> findByParaleloAndNivel(String paralelo, Integer nivel);

    List<RegistroEstudiante> findByNivel(Integer nivel);
    
    RegistroEstudiante findByEstudiante(Estudiante estudiante);
}
