package br.com.orange.jpa.test;

import br.com.orange.jpa.models.Aluno;
import br.com.orange.jpa.models.Resposta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CorrecaoPorNomeAluno {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("talents");
        EntityManager em = emf.createEntityManager();

        String jpql  = "select r from Resposta r where r.aluno = :pAluno";
        Aluno aluno = new Aluno();
        aluno.setId(1L);

        TypedQuery<Resposta> query = em.createQuery(jpql, Resposta.class);
        query.setParameter("pAluno", aluno);
        Resposta respostas = query.getSingleResult();
//        System.out.println(respostas.isEmpty());
//        for (Resposta resposta : respostas){
//            System.out.println("Aluno: " + resposta.getAluno().getNome());
//        }
        System.out.println(respostas.getAluno().getNome());
    }
}
