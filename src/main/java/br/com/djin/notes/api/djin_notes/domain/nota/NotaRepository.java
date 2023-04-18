package br.com.djin.notes.api.djin_notes.domain.nota;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    Page<Nota> findAll(Pageable pageable);
}
