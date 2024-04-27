package fr.uphf.Locataire.DTO;


import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class créationRequest {
    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;
}
