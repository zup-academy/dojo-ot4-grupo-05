package br.com.zupedu.dojo.ot4dojo.aluno;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupedu.dojo.ot4dojo.turma.Turma;
import br.com.zupedu.dojo.ot4dojo.turma.TurmaRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private TurmaRepository turmaRepository;

	public AlunoController(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> cadastroAluno(@PathVariable Long id){
		Optional<Turma> possivelTurma = turmaRepository.findById(id);
		
		if (possivelTurma.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
	}
}
