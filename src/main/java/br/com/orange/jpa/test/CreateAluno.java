package br.com.orange.jpa.test;

import br.com.orange.jpa.models.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateAluno {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("talents");
        EntityManager em = emf.createEntityManager();

        Aluno aluno1 = new Aluno("Gabriel", "gabriel@bento.com", 26);
        Aluno aluno2 = new Aluno("July", "july@bento.com", 21);
        Aluno aluno3 = new Aluno("Rafael", "rafael@bento.com", 20);
        Aluno aluno4 = new Aluno("Bruna", "bruna@bento.com", 23);
        Aluno aluno5 = new Aluno("Brenda", "brenda@bento.com", 24);
        Aluno aluno6 = new Aluno("Lucas", "lucas@bento.com", 22);

        em.getTransaction().begin();
        em.persist(aluno1);
        em.persist(aluno2);
        em.persist(aluno3);
        em.persist(aluno4);
        em.persist(aluno5);
        em.persist(aluno6);
        em.getTransaction().commit();
        em.close();
    }
}
