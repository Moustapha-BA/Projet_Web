package fr.uphf.bienImmobilier.resources;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping

public class BienResource {
    @Builder
    @Setter
    @Getter
    public static class bienDTO {
       private String id;
       private String type ;
       private int taille;
       private int nbPieces;
       private int numTel  ;
       private int prix ;
    }
    @GetMapping
    public ResponseEntity<bienDTO> getBien() {
        System.out.println("Requête reçue pour lister les biensImmobilier");
        return ResponseEntity.ok((bienDTO) Arrays.asList(
                bienDTO.builder().id("1").type("Maison").taille(100).nbPieces(5).numTel(123456789).prix(100000).build(),
                bienDTO.builder().id("2").type("Appartement").taille(50).nbPieces(3).numTel(987654321).prix(50000).build(),
                bienDTO.builder().id("3").type("Maison").taille(150).nbPieces(7).numTel(123456789).prix(150000).build(),
                bienDTO.builder().id("4").type("Appartement").taille(70).nbPieces(4).numTel(987654321).prix(70000).build(),
                bienDTO.builder().id("5").type("Maison").taille(200).nbPieces(9).numTel(123456789).prix(200000).build(),
                bienDTO.builder().id("6").type("Appartement").taille(90).nbPieces(5).numTel(987654321).prix(90000).build(),
                bienDTO.builder().id("7").type("Maison").taille(250).nbPieces(11).numTel(123456789).prix(250000).build(),
                bienDTO.builder().id("8").type("Appartement").taille(110).nbPieces(6).numTel(987654321).prix(110000).build(),
                bienDTO.builder().id("9").type("Maison").taille(300).nbPieces(13).numTel(123456789).prix(300000).build(),
                bienDTO.builder().id("10").type("Appartement").taille(130).nbPieces(7).numTel(987654321).prix(130000).build()
        ));
    }

}
