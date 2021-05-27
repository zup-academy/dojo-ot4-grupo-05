package br.com.zupedu.dojo.ot4dojo.aluno;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zupedu.dojo.ot4dojo.turma.Turma;
import br.com.zupedu.dojo.ot4dojo.turma.TurmaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@PersistenceContext
	private EntityManager manager;

	private TurmaRepository turmaRepository;

	public AlunoController(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	@PostMapping("/{id}")
	@Transactional
	public ResponseEntity<?> cadastroAluno(@PathVariable Long id, @RequestBody @Valid AlunoRequest request){
		Optional<Turma> possivelTurma = turmaRepository.findById(id);
		
		if (possivelTurma.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Aluno aluno = request.converter(possivelTurma.get());
		manager.persist(aluno);
		return ResponseEntity.created(null).build();
	}
}
