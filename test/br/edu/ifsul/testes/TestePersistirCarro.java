
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Marca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ricardo/Joel
 */
public class TestePersistirCarro {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCarro() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2018-Etapa2-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
           em.getTransaction().begin();
            Carro obj = new Carro();
            obj.setAno("1975");
            obj.setCor("Preto");
            obj.setModelo("Civic");
            obj.setPlaca("IBG0458");
            obj.setPotencia(1.3);
            obj.setPreco(12000.00);
            obj.setMarca(em.find(Marca.class, 1));
            
            em.persist(obj);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
