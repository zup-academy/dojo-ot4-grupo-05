package br.com.zupedu.dojo.ot4dojo.aluno;

import br.com.zupedu.dojo.ot4dojo.turma.Turma;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class AlunoRequest {
    @NotBlank
    @Email
    @Length(max = 30)
    private String email;

    @NotBlank
    @Length(max = 30)
    private String nome;

    @Min(18)
    private Integer idade;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Aluno converter(Turma possivelTurma) {
        return new Aluno(email, nome, idade, possivelTurma);
    }
}
