package br.com.orange.jpa.models;

import javax.persistence.*;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String solucao;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Avaliacao avaliacao;
    @JoinColumn(unique = true)
    @OneToOne
    private Correcao correcao;

    public Resposta(String solucao, Aluno aluno, Avaliacao avaliacao, Correcao correcao) {
        this.solucao = solucao;
        this.aluno = aluno;
        this.avaliacao = avaliacao;
        this.correcao = correcao;
    }

    public Resposta(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Correcao getCorrecao() {
        return correcao;
    }

    public void setCorrecao(Correcao correcao) {
        this.correcao = correcao;
    }

}
