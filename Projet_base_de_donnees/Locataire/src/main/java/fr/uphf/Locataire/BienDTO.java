package fr.uphf.Locataire;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BienDTO {
    private Long id;
    private String adresse;
    private String type;
    private int surface;
    private int nbPieces;
    private int loyer;

}