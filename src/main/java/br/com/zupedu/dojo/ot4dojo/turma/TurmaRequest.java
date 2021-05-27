package br.com.zupedu.dojo.ot4dojo.turma;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TurmaRequest {

    @Length(max = 50) @NotBlank
    private String nome;
    @NotNull
    private LocalDate iniciaEm;
    @NotNull
    private LocalDate terminaEm;

    public TurmaRequest(String nome, LocalDate iniciaEm, LocalDate terminaEm) {
        this.nome = nome;
        this.iniciaEm = iniciaEm;
        this.terminaEm = terminaEm;
    }

    public Turma toModel(){
        return new Turma(nome, iniciaEm, terminaEm);
    }
}