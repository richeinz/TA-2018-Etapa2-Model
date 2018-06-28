
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Imagem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class TestePersistirImagem {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirImagem() {
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
            Carro c = em.find(Carro.class, 9);
            Imagem i = new Imagem();
            Path path = Paths.get("C:\\Users\\Ricardo\\Documents\\NetBeansProjects\\TA-2018-Etapa2-Model\\src\\br\\edu\\ifsul\\img\\fusca1.jpg");
            i.setArquivo(Files.readAllBytes(path));
            c.adicionarImagem(i);         
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
