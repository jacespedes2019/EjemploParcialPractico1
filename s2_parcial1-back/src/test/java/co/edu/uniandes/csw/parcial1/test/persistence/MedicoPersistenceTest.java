/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.test.persistence;

import co.edu.uniandes.csw.parcial1.entities.MedicoEntity;
import co.edu.uniandes.csw.parcial1.persistence.MedicoPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
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
public class MedicoPersistenceTest {
    
    @Inject
    MedicoPersistence mp;
     
    @PersistenceContext
    private EntityManager em; 
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedicoEntity.class.getPackage())
                .addPackage(MedicoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml" );       
    }
    
    @Test
    public void createVideoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        MedicoEntity medico= factory.manufacturePojo(MedicoEntity.class);
        MedicoEntity result = mp.create(medico);
        Assert.assertNotNull(result);
        MedicoEntity entidadMedico = em.find(MedicoEntity.class, result.getId());
        Assert.assertEquals(medico.getApellido(), entidadMedico.getApellido());
    }
}
