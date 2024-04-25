package fr.uphf.Locataire.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BienImmoDTO {
    private Long id;
    private String adresse;
    private String type;
    private int surface;
    private int nbPieces;
    private int loyer;

}