package br.com.zupedu.dojo.ot4dojo.avaliacao;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
}
