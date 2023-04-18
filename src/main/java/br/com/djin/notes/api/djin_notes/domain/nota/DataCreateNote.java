package br.com.djin.notes.api.djin_notes.domain.nota;

import jakarta.validation.constraints.NotBlank;

public record DataCreateNote(
        @NotBlank
        String title,
        @NotBlank
        String body
) { }
