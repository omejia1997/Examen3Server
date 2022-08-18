/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen3p.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "registroEstudiante")
public class RegistroEstudiante {
    
    @Id
    private String id;

    private String paralelo;
    
    private Integer nivel;
 
    private Estudiante estudiante;
    
}
