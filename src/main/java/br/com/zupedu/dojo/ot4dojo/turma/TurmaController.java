package br.com.zupedu.dojo.ot4dojo.turma;

import java.net.URI;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private TurmaRepository turmaRepository;

    @Autowired
    public TurmaController(TurmaRepository turmaRepository){
        this.turmaRepository = turmaRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> criaTurma(@RequestBody @Valid TurmaRequest request){

        Boolean existe = turmaRepository.existsByNome(request.getNome());
        boolean existeData = turmaRepository.existsByIniciaEm(request.getIniciaEm());

        if(existe || existeData){
            return ResponseEntity.badRequest().body("Já existe!");
        }

        Turma turma = request.toModel();
        turmaRepository.save(turma);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(turma.getId()).toUri();
        return ResponseEntity.created(uri).body(new TurmaResponse(turma));
    }
}
