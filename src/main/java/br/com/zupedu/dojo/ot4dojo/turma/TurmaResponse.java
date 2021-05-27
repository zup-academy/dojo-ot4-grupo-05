package br.com.zupedu.dojo.ot4dojo.turma;

import java.time.LocalDate;

public class TurmaResponse {

    private Long id;
    private String nome;
    private LocalDate iniciaEm;
    private LocalDate terminaEm;

    public TurmaResponse(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.iniciaEm = turma.getIniciaEm();
        this.terminaEm = turma.getTerminaEm();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getIniciaEm() {
        return iniciaEm;
    }

    public LocalDate getTerminaEm() {
        return terminaEm;
    }
}
