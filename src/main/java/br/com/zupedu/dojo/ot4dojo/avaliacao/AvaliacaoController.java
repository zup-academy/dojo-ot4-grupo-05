package br.com.zupedu.dojo.ot4dojo.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AvaliacaoRequest avaliacaoRequest) {
    	Avaliacao avaliacao = avaliacaoRequest.toModel();
    	avaliacaoRepository.save(avaliacao);

        return ResponseEntity.created(null).build();
    }

}
