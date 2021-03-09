/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.test.logic;

import co.edu.uniandes.csw.parcial1.ejb.MedicoLogic;
import co.edu.uniandes.csw.parcial1.entities.MedicoEntity;
import co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.parcial1.persistence.MedicoPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Jairo Céspedes
 */
@RunWith(Arquillian.class)
public class MedicoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private MedicoLogic medicoLogic; 
    
    @PersistenceContext
    private EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedicoEntity.class.getPackage())
                .addPackage(MedicoPersistence.class.getPackage())
                .addPackage(MedicoLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml" );
    }
    
    @Test
    public void createMedico() throws BusinessLogicException{
        MedicoEntity nuevoMedico= factory.manufacturePojo(MedicoEntity.class);
        MedicoEntity resultado= medicoLogic.createMedico(nuevoMedico);
        Assert.assertNotNull(resultado);       
        MedicoEntity entidad = em.find(MedicoEntity.class, resultado.getId());
        Assert.assertEquals(entidad.getApellido(), resultado.getApellido());       
    }
    
    @Test (expected = BusinessLogicException.class)
    public void createMedicoWithError() throws BusinessLogicException{
        MedicoEntity nuevoMedico= factory.manufacturePojo(MedicoEntity.class);
        nuevoMedico.setEspecialidad("No");
        MedicoEntity resultado= medicoLogic.createMedico(nuevoMedico);   
    }
}
