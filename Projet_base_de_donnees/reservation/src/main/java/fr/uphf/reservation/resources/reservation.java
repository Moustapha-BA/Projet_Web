// 1. Création de l'entité Reservation
package fr.uphf.reservation.resources;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long locataireId;

    private Long bienImmoId;

    private LocalDate dateDebut;

    private LocalDate dateFin;
    private  int loyer;
}