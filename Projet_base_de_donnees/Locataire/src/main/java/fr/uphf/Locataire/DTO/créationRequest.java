package fr.uphf.Locataire.DTO;


import lombok.Data;

@Data
public class créationRequest {
    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;
}
