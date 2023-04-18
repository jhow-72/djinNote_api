package br.com.djin.notes.api.djin_notes.domain.nota;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public record DataUpdateNote(
        @Id
        Long id,
        @NotBlank
        String body
) { }
