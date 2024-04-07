package fr.uphf.Locataire;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locataire")
public class locataire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nom;

    private String prenom;

    private String adresse;

    private String numTel;



}
