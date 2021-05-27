package br.com.zupedu.dojo.ot4dojo.avaliacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
    private String descricao;
    
    @Deprecated
    public Avaliacao() {/*To Hibernate*/}
	public Avaliacao(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
    
    

}
