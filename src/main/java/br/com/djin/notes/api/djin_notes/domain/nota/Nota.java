package br.com.djin.notes.api.djin_notes.domain.nota;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="notas")
@Entity(name="Nota")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Nota {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title, body;

    public Nota(DataCreateNote data) {
        this.title = data.title();
        this.body = data.body();
    }

    public void updateInfos(DataUpdateNote data) {
        this.body = data.body();
    }
}
