/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.ejb;

import co.edu.uniandes.csw.parcial1.entities.MedicoEntity;
import co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.parcial1.persistence.MedicoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jairo Céspedes
 */
@Stateless
public class MedicoLogic {
    @Inject
    private MedicoPersistence persistence;
    //No puede haber dos médicos con el mismo número de registro
    //Los nombres y apellidos no pueden ser nulos o vacíos
    //La especialidad debe tener más de 4 caracteres
     public MedicoEntity createMedico(MedicoEntity medicoEntity) throws BusinessLogicException{
          if(persistence.findByRegistro(medicoEntity.getRegistroMedico())!=null) {
            throw new BusinessLogicException("Ya existe un médico con ese registro");
            }
          if(medicoEntity.getNombre().equals("")|| medicoEntity.getNombre()==null || medicoEntity.getApellido().equals("")|| medicoEntity.getApellido()==null){
            throw new BusinessLogicException("Los nombres y apellidos no pueden ser nulos o vacíos");
            }
          if(medicoEntity.getEspecialidad().length()<=4){
            throw new BusinessLogicException("La especialidad debe tener más de 4 caracteres");
            }
          medicoEntity =persistence.create(medicoEntity);
          return medicoEntity;
     }
    
}
