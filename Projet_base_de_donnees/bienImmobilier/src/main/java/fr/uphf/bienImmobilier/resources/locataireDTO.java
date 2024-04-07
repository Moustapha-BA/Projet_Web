package fr.uphf.bienImmobilier.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class locataireDTO {
    private Long id;

    private String nom;

    private String prenom;

    private String adresse;

    private String numTel;
}
