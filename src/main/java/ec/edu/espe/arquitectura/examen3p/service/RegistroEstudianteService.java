/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package ec.edu.espe.arquitectura.examen3p.service;

import ec.edu.espe.arquitectura.examen3p.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.examen3p.dao.RegistroEstudianteRepository;
import ec.edu.espe.arquitectura.examen3p.dto.RegistroEstudianteRQ;
import ec.edu.espe.arquitectura.examen3p.model.RegistroEstudiante;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RegistroEstudianteService {

   RegistroEstudianteRepository registroEstudianteRepo;
   EstudianteRepository estudianteRepo;

    public RegistroEstudianteService(RegistroEstudianteRepository registroEstudianteRepo, EstudianteRepository estudianteRepo) {
        this.registroEstudianteRepo = registroEstudianteRepo;
        this.estudianteRepo = estudianteRepo;
    }

    public List<RegistroEstudiante> findByNivel(Integer nivel) {
        return this.registroEstudianteRepo.findByNivel(nivel);
    }

    public List<RegistroEstudiante> findByParaleloAndNivel(String paralelo, Integer nivel) {
        return registroEstudianteRepo.findByParaleloAndNivel(paralelo, nivel);
    }
    public Integer getCountFindByParaleloAndNivel(String paralelo, Integer nivel) {
        return registroEstudianteRepo.findByParaleloAndNivel(paralelo, nivel).size();
    }


    public void saveWithRegistroEstudiante(RegistroEstudianteRQ registroEstudianteRQ) throws Exception {
        
        RegistroEstudiante registroEstudiante = this.registroEstudianteRepo.findByEstudiante(
                this.estudianteRepo.findByCedula(registroEstudianteRQ.getCedula()));
        
         registroEstudiante.setParalelo(this.getParaleloLibre(registroEstudianteRQ.getNivel()));

        this.registroEstudianteRepo.save(registroEstudiante);
    }


    public String getParaleloLibre(Integer nivel){
        Integer countParaleloA = this.getCountFindByParaleloAndNivel("A", nivel);
        Integer countParaleloB = this.getCountFindByParaleloAndNivel("B", nivel);
        Integer countParaleloC = this.getCountFindByParaleloAndNivel("C", nivel);
        
        if(countParaleloA < countParaleloB){
            if(countParaleloA < countParaleloC){
                return "A";
            }
        }else if(countParaleloB < countParaleloC)
                return "B";
            
        return "C";
        
    }
}
