package br.com.djin.notes.api.djin_notes.domain.nota;

public record DataDetailingNote(Long id, String title, String body) {
    public DataDetailingNote (Nota nota){
        this(nota.getId(), nota.getTitle(), nota.getBody());
    }
}
