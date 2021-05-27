package br.com.zupedu.dojo.ot4dojo.turma;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Boolean existsByNome(String nome);
    boolean existsByIniciaEm(LocalDate data);
}
