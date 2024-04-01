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
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "numTel")
    private String numTel;



}
