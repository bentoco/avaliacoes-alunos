package br.com.orange.jpa.test;

import br.com.orange.jpa.models.Aluno;
import br.com.orange.jpa.models.Avaliacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateAvaliacao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("talents");
        EntityManager em = emf.createEntityManager();

        Avaliacao ava1 = new Avaliacao("JPA2 HIBERNATE", "FAÇA UMA APLICAÇÃO COM JPA UTILIZANDO HIBERNATE COM AS SEGUINTES ENTIDADES: ALUNO E AVALIAÇÃO.");
        Avaliacao ava2 = new Avaliacao("MYSQL", "CRIE DUAS TABELAS, UMA CARRO COM COR ANO PLACA E MODELO, OUTRA DE MOTO COM OS MESMO ATRIBUTOS.");

        em.getTransaction().begin();
        em.persist(ava1);
        em.persist(ava2);
        em.getTransaction().commit();
        em.close();
    }
}
