package br.com.orange.jpa.test;

import br.com.orange.jpa.models.Avaliacao;
import br.com.orange.jpa.models.Correcao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateCorrecao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("talents");
        EntityManager em = emf.createEntityManager();

        Correcao corr3 = new Correcao(11);


        em.getTransaction().begin();
        em.persist(corr3);

        em.getTransaction().commit();
        em.close();
    }
}
