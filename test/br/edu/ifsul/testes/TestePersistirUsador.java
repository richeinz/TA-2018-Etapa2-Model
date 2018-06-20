/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autorizacao;
import br.edu.ifsul.modelo.Usador;
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
public class TestePersistirUsador {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirUsador() {
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
            Usador obj = new Usador();
            obj.setName("Joel Zatti");
            obj.setPassword("123456");
            obj.setUsador("joel.zatti");
            Autorizacao p = em.find(Autorizacao.class, "ROOT");
            //Autorizacao p1 = em.find(Autorizacao.class, "CLIENTE");
            obj.getAutorizacoes().add(p);
            //obj.getAutorizacoes().add(p1);
            em.persist(obj);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
