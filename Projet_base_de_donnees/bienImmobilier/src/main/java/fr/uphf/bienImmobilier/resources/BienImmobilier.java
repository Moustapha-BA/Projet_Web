package fr.uphf.bienImmobilier.resources;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BienImmobilier {

    @Getter
    @Setter
    public static class LocataireDTO {
        @Getter
        private Long id;
        private String nom;
        private String prenom;
        private String adresse;
        private String numTel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    private String type;
    private int surface;
    private int nbPieces;
    private int loyer;
    private List<LocataireDTO> locataires;
}