/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package ec.edu.espe.arquitectura.examen3p.dao;

import ec.edu.espe.arquitectura.examen3p.model.Estudiante;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    boolean existsByCedula(String cedula);

    Estudiante findByCedula(String cedula);
}

