package fr.uphf.bienImmobilier.resources;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class BienImmobilier {
    public static class LocataireDTO {

        private Long id;
        private String nom;
        private String prenom;
        private String adresse;
        private String numTel;
        public Long getId() {
            return id;
        }
    }

    @Id
    private Long id;
    private String adresse;
    private String type;
    private int surface;
    private int nbPieces;
    private int loyer;
    private List<LocataireDTO> locataires;
}