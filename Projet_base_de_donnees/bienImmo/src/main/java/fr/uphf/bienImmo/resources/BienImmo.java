package fr.uphf.bienImmo.resources;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BienImmo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBienImmo")
    private Long id;

    private String adresse;

    private String type;

    private int surface;

    private int nbPieces;

    private int loyer;
}
