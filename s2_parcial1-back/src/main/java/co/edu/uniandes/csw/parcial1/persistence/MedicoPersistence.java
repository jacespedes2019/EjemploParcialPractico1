/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.persistence;

import co.edu.uniandes.csw.parcial1.entities.MedicoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jairo Céspedes
 */

@Stateless
public class MedicoPersistence {
    
    @PersistenceContext( unitName = "parcial1PU")
    protected EntityManager em;
    
    public MedicoEntity create(MedicoEntity medicoEntity) {
        em.persist(medicoEntity);
        return medicoEntity;
    }
    
    public MedicoEntity findByRegistro(String registro) {
        TypedQuery query = em.createQuery("Select e From MedicoEntity e where e.registroMedico = :registroMedico", MedicoEntity.class);
        query = query.setParameter("registroMedico", registro);
        List<MedicoEntity> igualRegistro = query.getResultList();
         MedicoEntity resultado;
        if (igualRegistro == null) {
            resultado = null;
        } else if (igualRegistro.isEmpty()) {
            resultado = null;
        } else {
            resultado = igualRegistro.get(0);
        }
        
        return resultado;
    }
}
