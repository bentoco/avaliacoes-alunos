package br.com.orange.jpa.test;

import br.com.orange.jpa.models.Aluno;
import br.com.orange.jpa.models.Avaliacao;
import br.com.orange.jpa.models.Correcao;
import br.com.orange.jpa.models.Resposta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateResposta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("talents");
        EntityManager em = emf.createEntityManager();

        Aluno aluno = new Aluno();
        aluno.setId(1L);

        Avaliacao ava = new Avaliacao();
        ava.setId(7L);

        Correcao corr = new Correcao();
        corr.setId(9L);


        Resposta resp1 = new Resposta();
        resp1.setSolucao("Mussum Ipsum, cacilds vidis litro abertis. Viva Forevis aptent taciti sociosqu ad litora torquent. Detraxit consequat et quo num tendi nada. Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis. Quem num gosta di mim que vai caçá sua turmis! ");
        resp1.setAluno(aluno);
        resp1.setAvaliacao(ava);
        resp1.setCorrecao(corr);

        em.getTransaction().begin();
        em.persist(resp1);
        em.getTransaction().commit();
        em.close();
    }
}
