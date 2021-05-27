package br.com.zupedu.dojo.ot4dojo.avaliacao;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class AvaliacaoRequest {

    @NotBlank
    @Length(max = 50)
    private String titulo;

    @Length(min = 100, max = 500)
    private String descricao;



    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

	public Avaliacao toModel() {
		return new Avaliacao(titulo, descricao);
		
	}
}
