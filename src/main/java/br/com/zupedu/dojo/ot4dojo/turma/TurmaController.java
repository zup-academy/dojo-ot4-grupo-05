package br.com.zupedu.dojo.ot4dojo.turma;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class TurmaController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    public void criaTurma(@RequestBody @Valid TurmaRequest request,
                          UriComponentsBuilder builder){
        Turma turma = request.toModel();
        manager.persist(turma);
    }
}
