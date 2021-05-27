package br.com.zupedu.dojo.ot4dojo.aluno;

import br.com.zupedu.dojo.ot4dojo.turma.Turma;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email @Length(max = 30)
    @Column(length = 30)
    private String email;

    @Length(max = 30)
    @Column(length = 30)
    private String nome;

    @Min(18)
    private Integer idade;

    @ManyToOne
    private Turma turma;

    public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(@Email @Length(max = 30) String email, @Length(max = 30) String nome, @Min(18) Integer idade,
			Turma turma) {
		this.email = email;
		this.nome = nome;
		this.idade = idade;
		this.turma = turma;
	}
    
    
}
