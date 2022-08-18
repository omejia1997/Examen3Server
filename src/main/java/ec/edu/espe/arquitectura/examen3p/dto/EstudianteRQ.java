/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen3p.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class EstudianteRQ {
    private String cedula;

    private String nombres;

    private String apellidos;
    
    private Integer nivel;
}
