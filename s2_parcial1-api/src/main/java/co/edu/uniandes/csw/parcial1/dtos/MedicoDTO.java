/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.dtos;

import co.edu.uniandes.csw.parcial1.entities.MedicoEntity;
import java.io.Serializable;

/**
 *
 * @author josejbocanegra
 */
public class MedicoDTO implements Serializable {
    
    private Long id;
    private String nombre;
    private String apellido;
    private String registroMedico;
    private String especialidad;
    
    public MedicoDTO(){
        
    }
    
    public MedicoDTO(MedicoEntity medicoEntity) {
        if(medicoEntity!=null){
            this.apellido=medicoEntity.getApellido();
            this.id=medicoEntity.getId();
            this.nombre=medicoEntity.getNombre();
            this.especialidad=medicoEntity.getEspecialidad();
            this.registroMedico=medicoEntity.getRegistroMedico();
        }
    }
    
    public MedicoEntity toEntity() {
        MedicoEntity medicoEntity= new MedicoEntity();
        medicoEntity.setApellido(getApellido());
        medicoEntity.setEspecialidad(getEspecialidad());
        medicoEntity.setId(getId());
        medicoEntity.setNombre(getNombre());
        medicoEntity.setRegistroMedico(getRegistroMedico());
        
        return medicoEntity;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the registroMedico
     */
    public String getRegistroMedico() {
        return registroMedico;
    }

    /**
     * @param registroMedico the registroMedico to set
     */
    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }
    
}
