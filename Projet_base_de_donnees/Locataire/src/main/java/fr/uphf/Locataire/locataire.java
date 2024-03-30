package fr.uphf.Locataire;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class locataire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;


}
