package fr.uphf.Locataire;


import lombok.Data;

@Data
public class créationRequest {
    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;
}
