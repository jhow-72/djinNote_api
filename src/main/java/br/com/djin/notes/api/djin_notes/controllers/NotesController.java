package br.com.djin.notes.api.djin_notes.controllers;

import br.com.djin.notes.api.djin_notes.domain.nota.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("notas")
public class NotesController {

    @Autowired
    private NotaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DataCreateNote data, UriComponentsBuilder uriComponentsBuilder){
        Nota nota = new Nota(data);
        repository.save(nota);
        URI uri = uriComponentsBuilder.path("notas/{id}").buildAndExpand(nota.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailingNote(nota));
    }

    @GetMapping
    public ResponseEntity<Page<DataDetailingNote>> read(@PageableDefault(size=10, sort={"title"}) Pageable pageable){
        Page<DataDetailingNote> page = repository.findAll(pageable).map(DataDetailingNote::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDetailingNote> readOne(@PathVariable Long id){
        Nota nota = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailingNote(nota));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataDetailingNote> updateOne(@RequestBody @Valid DataUpdateNote data){
        Nota nota = repository.getReferenceById(data.id());
        nota.updateInfos(data);
        return ResponseEntity.ok(new DataDetailingNote(nota));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
